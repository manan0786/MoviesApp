package com.example.moviesapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {


    private String movie_title;
    private String posterpath;
    private String releasedate;
    private String movie_overview;
    private int movie_id;
    private float voteaverage;

    // Constructors

    public MovieModel(String movie_title, String posterpath, String releasedate, String movie_overview, int movie_id, float voteaverage) {
        this.movie_title = movie_title;
        this.posterpath = posterpath;
        this.releasedate = releasedate;
        this.movie_overview = movie_overview;
        this.movie_id = movie_id;
        this.voteaverage = voteaverage;
    }

    // Parcelable Usage
    protected MovieModel(Parcel in) {
        movie_title = in.readString();
        posterpath = in.readString();
        releasedate = in.readString();
        movie_overview = in.readString();
        movie_id = in.readInt();
        voteaverage = in.readFloat();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    //Getters
    public String getMovie_title() {
        return movie_title;
    }

    public String getPosterpath() {
        return posterpath;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public String getMovie_overview() {
        return movie_overview;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public float getVoteaverage() {
        return voteaverage;
    }

    // Parcelable Implementation Methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movie_title);
        dest.writeString(posterpath);
        dest.writeString(releasedate);
        dest.writeString(movie_overview);
        dest.writeInt(movie_id);
        dest.writeFloat(voteaverage);
    }
}
