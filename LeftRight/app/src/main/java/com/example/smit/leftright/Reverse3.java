package com.example.smit.leftright;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Reverse3 extends AppCompatActivity{
    TextView score,level;
    int Score=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reverse3_pre);
        Intent intent = getIntent();
        score=findViewById(R.id.score_text);
        Score = Integer.parseInt(intent.getStringExtra(key.SCORE));
        level=findViewById(R.id.level);
        score.setText("Score : "+Score);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Reverse3.this, Level3.class)
                        .putExtra(key.SCORE, String.valueOf(Score)));
                Reverse3.this.finish();
            }
        },2000);

    }
}