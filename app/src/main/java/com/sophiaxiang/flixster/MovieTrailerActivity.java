package com.sophiaxiang.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.sophiaxiang.flixster.databinding.ActivityMovieDetailsBinding;
import com.sophiaxiang.flixster.databinding.ActivityMovieTrailerBinding;

public class MovieTrailerActivity extends YouTubeBaseActivity {

    ActivityMovieTrailerBinding binding;
    YouTubePlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_movie_trailer.xml -> ActivityMovieTrailerBinding
        binding = ActivityMovieTrailerBinding.inflate(getLayoutInflater());

        // layout of activity is stored in a special property called root
        setContentView(binding.getRoot());

        //get videoKey from intent and create new variable
        Intent intent = getIntent();
        String videoKey = intent.getExtras().getString("movieKey");

        // resolve the player view from the layout
        //YouTubePlayerView playerView = (YouTubePlayerView) findViewById(R.id.player);
        playerView = binding.player;

        //initialize with API key stored in secrets.xml
        playerView.initialize("AIzaSyDE-6GIZXf9o3HTuZ1YK5nTWqrMd1mtXYE", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                // do any work here to cue video, play video, etc.
                youTubePlayer.cueVideo(videoKey);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                // log the error
                Log.e("MovieTrailerActivity", "Error initializing YouTube player");
            }
        });
    }
}