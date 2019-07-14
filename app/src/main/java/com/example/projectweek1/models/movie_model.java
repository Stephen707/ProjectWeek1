package com.example.projectweek1.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class movie_model {


    String poster_path;
    String title;
    String overview;
    String release_date;
    String original_language;
    String backdrop_path;

    public movie_model (JSONObject jsonObject) throws JSONException {
        poster_path = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        original_language = jsonObject.getString("original_language");
        release_date = jsonObject.getString("release_date");
        backdrop_path = jsonObject.getString("backdrop_path");

    }
    public static List<movie_model> fromJson (JSONArray moviejsonArray) throws JSONException {
        List<movie_model> movie = new ArrayList<>();
        for (int i =0; i < moviejsonArray.length(); i++){
            movie.add(new movie_model(moviejsonArray.getJSONObject(i)));
        }
        return movie;
    }

    public String getBackdrop_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdrop_path);
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getPoster_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",poster_path);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
