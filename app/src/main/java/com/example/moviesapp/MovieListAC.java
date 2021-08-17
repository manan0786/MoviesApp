package com.example.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.moviesapp.Dialog.ResponseDialog;
import com.example.moviesapp.Models.MovieModel;
import com.example.moviesapp.Network.ApiUri;
import com.example.moviesapp.Network.MovieApiInterface;
import com.example.moviesapp.Network.Service;
import com.example.moviesapp.Response.MovieSearchResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListAC extends AppCompatActivity implements View.OnClickListener{
    AppCompatActivity mContext;


    @BindView(R.id.btn)
    Button Get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);

        ButterKnife.bind(this);
        mContext = this;

        //    TODO: OnClickListeners
        Get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                GetRetrofitResponse();
                //            TODO: SHow Progress Dialog
                ResponseDialog.showProgressDialog(mContext,
                        R.string.check,
                        R.string.plz_w8);
                break;
        }
    }

    private void GetRetrofitResponse() {
        MovieApiInterface movieApi = Service.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi
        .searchMovie(
                ApiUri.API_KEY,
                "Jack Reacher",
                1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200){

                    Log.v("Tag", "the response is "+ response.body().toString());
                    List<MovieModel> modelList = new ArrayList<>(response.body().getMoviesList());
                    for(MovieModel movieModel: modelList){
                        Log.v("Tag", "The List is "+ movieModel.getReleasedate());
                    }
                }
                else{
                        ResponseDialog.dismissProgressDialog();
                        if (response.code() == 500) {
                            ResponseDialog.showFailedNotification(
                                    mContext,
                                    getString(R.string.alert),
                                    getString(R.string.server_not_respond));
                        }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
                ResponseDialog.dismissProgressDialog();


                ResponseDialog.showFailedNotification(
                        mContext,
                        getString(R.string.alert),
                        t.getMessage());

                Log.d("ResponseError", t.getMessage());
            }
        });


    }
}