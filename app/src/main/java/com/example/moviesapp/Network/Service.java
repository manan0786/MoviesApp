package com.example.moviesapp.Network;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Service {

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(ApiUri.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();




  private static MovieApiInterface movieApi = retrofit.create(MovieApiInterface.class);
    public static MovieApiInterface getMovieApi(){
        return movieApi;
    }
}
