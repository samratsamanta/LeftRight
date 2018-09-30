package com.example.smit.leftright;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Level1_pre extends AppCompatActivity{
    TextView score,level;
    int Score=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_level1);
        score=findViewById(R.id.score_text);
        level=findViewById(R.id.level);
        score.setText("Score : "+Score);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Level1_pre.this, Level1.class)
                        .putExtra(key.SCORE, String.valueOf(Score)));
                Level1_pre.this.finish();
            }
        },2000);

    }
}