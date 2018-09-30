package com.example.smit.leftright;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Level3_pre extends AppCompatActivity {
    TextView textView;
    int score;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level3_pre);
        Intent intent = getIntent();
        textView=findViewById(R.id.score_text);
        score = Integer.parseInt(intent.getStringExtra(key.SCORE));
        textView.setText("Score : "+String.valueOf(score));
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Level3_pre.this, Level3.class)
                        .putExtra(key.SCORE, String.valueOf(score)));
                Level3_pre.this.finish();
            }
        },2000);
    }
}
