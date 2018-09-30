package com.example.smit.leftright;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Level_Change extends AppCompatActivity{
    TextView score;
    int Score=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reverse1_pre);
        score.setText("Score : "+Score);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Level_Change.this, Reverse1.class)
                        .putExtra(key.SCORE, String.valueOf(Score)));
                Level_Change.this.finish();
            }
        },3000);

    }
}