package com.sophiaxiang.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.sophiaxiang.flixster.databinding.ActivityMovieDetailsBinding;
import com.sophiaxiang.flixster.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import okhttp3.Headers;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String TAG = "MovieDetailsActivity";

    Movie movie;
    TextView tvDetailsTitle;
    TextView tvOverview;
    RatingBar rbVoteAverage;
    ImageView ivBackDrop;
    ActivityMovieDetailsBinding activityMovieDetailsBinding;
    String youtubeKey;
    ImageView ivPlayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_movie_details);
        activityMovieDetailsBinding = ActivityMovieDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityMovieDetailsBinding.getRoot());

        // unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie)Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        // resolve the view objects
        tvDetailsTitle = activityMovieDetailsBinding.tvDetailsTitle;
        tvOverview = activityMovieDetailsBinding.tvOverview;
        rbVoteAverage = activityMovieDetailsBinding.rbVoteAverage;
        ivBackDrop = activityMovieDetailsBinding.ivBackDrop;
        ivPlayBtn = activityMovieDetailsBinding.ivPlayBtn;

        //set the title and overview
        tvDetailsTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        // vote average is 0..10, convert to 0..5 by dividing by 2
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage / 2.0f);

        //set BackDrop
        Glide.with(getApplicationContext()).load(movie.getBackdropPath())
                .placeholder(R.drawable.flicks_backdrop_placeholder)
                .into(ivBackDrop);

        Glide.with(getApplicationContext()).load(R.drawable.play_button)
                .into(ivPlayBtn);


        AsyncHttpClient client_video = new AsyncHttpClient();
        client_video.get("https://api.themoviedb.org/3/movie/" + movie.getId() + "/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject_video = json.jsonObject;
                try {
                    JSONArray videoResults = jsonObject_video.getJSONArray("results");
                    Log.i(TAG, "Results:" + videoResults.toString());
                    youtubeKey = videoResults.getJSONObject(1).getString("key");
                    Log.i(TAG, "YouTube key:" + youtubeKey);
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception with video", e);
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }

    public void launchActivity(Class klass){
        Intent intent = new Intent(this, klass);
        intent.putExtra("movieKey", youtubeKey);
        startActivity(intent);
    }

    public void launchMovieTrailerActivity(View view) {launchActivity(MovieTrailerActivity.class); }
}