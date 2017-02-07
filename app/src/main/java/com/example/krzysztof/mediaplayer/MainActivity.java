package com.example.krzysztof.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    private float volume = 1;
    private TextView volume_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volume_text = (TextView) findViewById(R.id.volume_text);
        volume_text.setText(Float.toString(volume));

        mediaPlayer = MediaPlayer.create(this, R.raw.lullabies_yuna);
        mediaPlayer.setVolume(volume, volume);
    }

    public void playSong(View view) {
        mediaPlayer.start();
    }

    public void pauseSong(View view) {
        mediaPlayer.pause();
    }

    public void volumeUp(View view) {
        volume+=0.1;
        if(volume<=1) {
            mediaPlayer.setVolume(volume ,volume);
            displayVol();
        }
    }

    public void volumeDown(View view) {
        volume-=0.1;
        if(volume>=0) {
            mediaPlayer.setVolume(volume ,volume);
            displayVol();
        }
    }

    private void displayVol() {
        volume_text.setText(Float.toString(volume));
    }
}
