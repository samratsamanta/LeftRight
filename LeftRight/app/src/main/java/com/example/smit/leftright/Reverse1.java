package com.example.smit.leftright;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Reverse1 extends AppCompatActivity{
    TextView score,level;
    int Score=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reverse1_pre);
        Intent intent = getIntent();
        score=findViewById(R.id.score_text);
        level=findViewById(R.id.level);
        Score = Integer.parseInt(intent.getStringExtra(key.SCORE));
        score.setText("Score : "+Score);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Reverse1.this, Level1.class)
                        .putExtra(key.SCORE, String.valueOf(Score)));
                Reverse1.this.finish();
            }
        },5000);

    }
}