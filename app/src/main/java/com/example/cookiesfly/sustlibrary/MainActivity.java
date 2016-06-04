package com.example.cookiesfly.sustlibrary;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp=new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //音乐播放
        MediaPlayer mp=MediaPlayer.create(this, R.raw.sky);
        mp.start();

        Button wifi = (Button) findViewById(R.id.wifi);
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new
                        Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });

        Button webmain = (Button) findViewById(R.id.library);
        webmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainWeb.class);
                startActivity(intent);
            }
        });

        Button sky = (Button) findViewById(R.id.music);
        //sky.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        mp.pause();
        //    }
        //});
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }
}

