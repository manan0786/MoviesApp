package com.example.moviesapp.Network;

import com.example.moviesapp.Models.MovieModel;
import com.example.moviesapp.Response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiInterface {
    //Search For Movies
    @GET("3/search/movie?")
    Call<MovieSearchResponse> searchMovie(@Query("api_key") String key, @Query("query") String query, @Query("page") int page);

    //Search Movie By Id
    @GET("3/movie/{movie_id}?")
    Call<MovieModel> getMovie(@Path("movie_id") int movie_id, @Query("api_key") String key);
}
