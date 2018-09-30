
package com.example.smit.leftright;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    Button left, right;
    TextView textView, mtextField;
    String clicked;
    public int score;
    int i1, i2, i = 0, x = 3000;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    MediaPlayer mp,mp1,mpn;

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }


    @Override
    public void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        score = Integer.parseInt(intent.getStringExtra(key.SCORE));
        setContentView(R.layout.level1_pre);
        textView = findViewById(R.id.text);
        mtextField = findViewById(R.id.mTextView);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        textView.setText(String.valueOf(score));
        mp = MediaPlayer.create(getApplicationContext(), R.raw.soundleft);
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.lose);
        mpn = MediaPlayer.create(getApplicationContext(), R.raw.nextlevel);
        final Random r = new Random();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setProgress(i);
        countDownTimer = new CountDownTimer(x, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.i("Log_tag", "Tick of Progress " + millisUntilFinished);
                i++;
                progressBar.setProgress(i * 100 / (x / 1000));
                mtextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mtextField.setText("done!");
                mp1.start();
                startActivity(new Intent(Level1.this, Bakwas.class)
                        .putExtra(key.SCORE, String.valueOf(score)));
                Level1.this.finish();
            }
        }.start();
        fun(r);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked.equals("Left") && score < 10) {
                    mp.start();
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun(r);
                    countDownTimer.start();
                    progressBar.setProgress(0);
                    if (score == 30)
                        Toast.makeText(Level1.this, "Reverse", Toast.LENGTH_SHORT).show();
                } else if (clicked.equals("Right") && score >= 30) {
                    mp.start();
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun(r);
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else {
                    mp1.start();
                    countDownTimer.cancel();
                    progressBar.setProgress(100);
                    startActivity(new Intent(Level1.this, Bakwas.class)
                            .putExtra(key.SCORE, String.valueOf(score)));
                    Level1.this.finish();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked.equals("Right") && score < 10) {
                    mp.start();
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun(r);
                    countDownTimer.start();
                    progressBar.setProgress(0);
                    if (score == 30)
                        Toast.makeText(Level1.this, "Reverse", Toast.LENGTH_SHORT).show();
                } else if (clicked.equals("Left") && score >= 30) {
                    mp.start();
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun(r);
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else {
                    mp1.start();
                    countDownTimer.cancel();
                    progressBar.setProgress(100);
                    startActivity(new Intent(Level1.this, Bakwas.class)
                            .putExtra(key.SCORE, String.valueOf(score)));
                    Level1.this.finish();
                }
            }
        });
    }

    void fun(Random r) {
        right.setText("");
        left.setText("");
        i = 0;
        i1 = r.nextInt(2);
        i2 = r.nextInt(2);
        if (i1 == 0) {             //left
            if (i2 == 0) {
                left.setText("Right");
                clicked = "Right";
            } else {
                left.setText("Left");
                clicked = "Left";
            }
        } else {                   //right
            if (i2 == 0) {
                right.setText("Right");
                clicked = "Right";
            } else {
                right.setText("Left");
                clicked = "Left";
            }
        }
    }

    void fun2() {
        if (score == 10) {
            countDownTimer.cancel();
            mpn.start();
            startActivity(new Intent(Level1.this, Level2_pre.class)
                    .putExtra(key.SCORE, String.valueOf(score)));
            Level1.this.finish();
        }
        else if (score==40){
            countDownTimer.cancel();
            mpn.start();
            startActivity(new Intent(Level1.this, Reverse2.class)
                    .putExtra(key.SCORE, String.valueOf(score)));
            Level1.this.finish();

        }
    }
}