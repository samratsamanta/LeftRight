package com.example.smit.leftright;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {

    String load = "Loading";
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        final TextView textView;
        Timer t;
        final ImageView imageView = findViewById(R.id.imageView);
        final ImageView imageV = findViewById(R.id.imageV);
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.antirotate);
        final Animation animation_2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        animation_1.setRepeatCount(Animation.INFINITE);
        animation_2.setRepeatCount(Animation.INFINITE);
        imageV.startAnimation(animation_1);
        imageView.startAnimation(animation_2);
        textView =  findViewById( R.id.te );
        t = new Timer();
        t.schedule( new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() //run on ui thread
                {
                public void run() {

                    count++;
                        textView.setText(load);
                        load=load.concat(".");
                        if(count==4)
                        {
                            count=0;
                            load="Loading";
                        }
                    }
                });
                    //}
                //});
            }
        }, 400, 400 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}