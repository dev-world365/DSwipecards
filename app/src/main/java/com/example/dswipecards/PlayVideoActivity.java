package com.example.dswipecards;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoActivity extends AppCompatActivity {

    VideoView vidView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        final ProgressDialog progressSpinner = new ProgressDialog(this);

        //Video URL
        //String vidAddress = "http://www.benairyresearch.net/dev/myVid02.mp4"; //works
        Bundle intent = getIntent().getExtras();
        String videoPath = intent.getString("VideoPath");

        //Prepare video
        vidView = (VideoView) findViewById(R.id.myVideo);
        Uri vidUri = Uri.parse(videoPath);
        vidView.setVideoURI(vidUri);
        vidView.requestFocus();

        //Prepare play controls like pause, rewind, forward, scrollbar
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);

        vidView.start();
        progressSpinner.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressSpinner.setMessage("Loading Video...");
        //progressSpinner.setIndeterminate(false);
        //progressSpinner.setCancelable(true);
        progressSpinner.show();

        //Close progress spinner when video has finished loading and ready to play
        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer player) {
                progressSpinner.dismiss();
            }
        });

        //Close video once finish playing and return to Main Activity
        vidView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                finish();
            }
        });


    }
}
