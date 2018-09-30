package com.example.smit.leftright;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    TextView textView;
    int sc,high;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        textView=findViewById(R.id.win);
        Intent intent = getIntent();
        String score = intent.getStringExtra(key.SCORE);
        sc=Integer.parseInt(score);
        high=Integer.parseInt(key.HIGH);
        if(sc>high) {
            key.HIGH=String.valueOf(sc);
            textView.setText("Your new High Score : "+score);
        }
        else
            textView.setText("");
    }
}
