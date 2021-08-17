package com.example.moviesapp.Response;

import com.example.moviesapp.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



// Class for getting single movie result

public class MovieResponse {
    //TODO: Give SerializedName So the retrofit could better know about the key and value.

    /*Movie Object*/
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public  MovieModel getMovie(){
        return movie;
    }

    //For Printing Results
    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
