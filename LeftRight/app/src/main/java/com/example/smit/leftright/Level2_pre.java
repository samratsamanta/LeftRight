package com.example.smit.leftright;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Level2_pre extends AppCompatActivity {
    int Score;
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2_pre);
        Intent intent = getIntent();
        textView = findViewById(R.id.score_text);
        Score = Integer.parseInt(intent.getStringExtra(key.SCORE));
        textView.setText("Score : " + String.valueOf(Score));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Level2_pre.this, Level2.class)
                        .putExtra(key.SCORE, String.valueOf(Score)));
                Level2_pre.this.finish();
            }
        }, 2000);
    }
}
