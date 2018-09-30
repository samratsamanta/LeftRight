package com.example.smit.leftright;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Bakwas extends AppCompatActivity{

    TextView textView;
    int sc,high;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bakwas);
        textView=findViewById(R.id.Lose);
        Intent intent = getIntent();
        String score = intent.getStringExtra(key.SCORE);
        sc=Integer.parseInt(score);
        high=Integer.parseInt(key.HIGH);
        if(sc>high) {
            key.HIGH=String.valueOf(sc);
            textView.setText("Your Score : "+score+"\nCongratulations you have achieved a new high score!!!");
        }
        else
        textView.setText("You Lose \n Your Score : "+score);
    }
}
