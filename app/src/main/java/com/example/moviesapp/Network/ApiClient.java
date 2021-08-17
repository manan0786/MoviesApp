package com.example.moviesapp.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private ApiInterface apiInterface;
    private static ApiClient apiClient;
    private Gson gson;
    private static  Retrofit retrofit;

    private ApiClient(){
        this.gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder().baseUrl(ApiUri.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        this.apiInterface = retrofit.create(ApiInterface.class);

    }

    public static ApiClient getInstance(){
        if (apiClient == null)
        {
            setInstance(new ApiClient());
        }
        return apiClient;
    }

    private static void setInstance(ApiClient apiClient)
    {
        ApiClient.apiClient = apiClient;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("Accept", "application/json");
                        builder.addHeader("Content-Type", "application/json");
                        return chain.proceed(builder.build());
                    }
                })
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

  private static ApiInterface movieApi = retrofit.create(ApiInterface.class);
}
