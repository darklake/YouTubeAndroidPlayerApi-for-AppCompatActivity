package com.darklake.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YouTubePlayerView player = findViewById(R.id.youtube_player_view);
        player.initialize("MAJORS", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.v("SUR", "onInitializationSuccess, provider : " + provider + ", youTubePlayer : " + youTubePlayer + ", b : " + b);
                youTubePlayer.setShowFullscreenButton(false);
                youTubePlayer.setFullscreen(false);
                youTubePlayer.loadVideo(getYoutubeVideoID("https://www.youtube.com/watch?v=ooVUSH3y2nA"));
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.v("SUR", "onInitializationFailure, provider : " + provider + ", youTubeInitializationResult : " + youTubeInitializationResult);
            }
        });
    }

    public static String getYoutubeVideoID(String url) {
        String id = "";
        Pattern pattern = Pattern.compile("^.*(?:(?:youtu\\.be\\/|v\\/|vi\\/|u\\/\\w\\/|embed\\/)|(?:(?:watch)?\\?v(?:i)?=|\\&v(?:i)?=))([^#\\&\\?]*).*",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            id = matcher.group(1);
        }

        return id;
    }
}