package com.example.smit.leftright;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button play,how,high,vol;
    MediaPlayer mp;
    int i=0,score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //overridePendingTransition(R.anim.antirotate,R.anim.antirotate);
        play=findViewById(R.id.play);
        how=findViewById(R.id.how);
        high=findViewById(R.id.high);
        vol=findViewById(R.id.vol);
        vol.setBackgroundResource(R.drawable.volume_up);
        Drawable d=vol.getBackground();
        mp=MediaPlayer.create(this,R.raw.pinkpanther);
        mp.setLooping(true);
        mp.setVolume(40,40);
        mp.start();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.pause();
                //mp.setVolume(20,20);
                //mp.start();
                startActivity(new Intent(MainActivity.this,Level1_pre.class)
                        .putExtra(key.SCORE, String.valueOf(score)));

            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HighScore.class));
                //MainActivity.this.finish();
            }
        });
        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HowToPlay.class));
                //MainActivity.this.finish();
            }
        });
        vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0) {
                    vol.setBackgroundResource(R.drawable.volume_off);
                    Drawable drawable = vol.getBackground();
                    mp.pause();
                    i=1;
                }
                else{
                    vol.setBackgroundResource(R.drawable.volume_up);
                    Drawable drawable = vol.getBackground();
                    mp.setVolume(100,100);
                    mp.start();
                    i=0;
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        vol.setBackgroundResource(R.drawable.volume_off);
        i=1;
        mp.pause();

    }

    @Override
    protected void onStart() {
        super.onStart();
        vol.setBackgroundResource(R.drawable.volume_up);
        i=0;
        mp.start();
    }
}
