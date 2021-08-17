package com.example.moviesapp.Response;


// Class for getting multiple movies result

import com.example.moviesapp.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {
    //TODO: Give SerializedName So the retrofit could better know about the key and value.


    @SerializedName("total_results")
    @Expose
    private int total_count;

    @SerializedName("results")
    @Expose
    private List<MovieModel> movieModelList;

    /*Returns Total Count of Movies*/
    public int getTotalCount(){
        return total_count;
    }
    public List<MovieModel> getMoviesList(){
        return movieModelList;
    }

    //For Printing Results
    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movieModelList=" + movieModelList +
                '}';
    }
}
