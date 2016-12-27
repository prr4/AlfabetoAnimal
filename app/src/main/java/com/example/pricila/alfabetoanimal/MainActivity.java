package com.example.pricila.alfabetoanimal;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
    int count = 1;
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final View contentView = findViewById(R.id.iv_image);
    }

    public void next(View v) {
        if(count<28) {
            mp.stop();
            count++;
        }
        else if(count==28) {
            mp.stop();
            count = 1;
        }

        Resources res = this.getResources();

        String img = "alfa"+count;
        String aud = "audio"+count;

        int imgId = res.getIdentifier(img, "drawable", this.getPackageName());
        ImageView imgView = (ImageView)findViewById(R.id.iv_image);
        imgView.setImageResource(imgId);

        int audId = res.getIdentifier(aud, "raw", this.getPackageName());
        mp = MediaPlayer.create(this, audId);
        mp.start();
    }

    public void prev(View v) {
        if(count>1) {
            mp.stop();
            count--;
        }

        Resources res = this.getResources();

        String img = "alfa"+count;
        String aud = "audio"+count;

        int imgId = res.getIdentifier(img, "drawable", this.getPackageName());
        ImageView imgView = (ImageView)findViewById(R.id.iv_image);
        imgView.setImageResource(imgId);

        int audId = res.getIdentifier(aud, "raw", this.getPackageName());
        mp = MediaPlayer.create(this, audId);
        mp.start();
    }
}