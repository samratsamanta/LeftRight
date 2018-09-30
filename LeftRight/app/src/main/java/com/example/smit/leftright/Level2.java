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

import static java.lang.System.currentTimeMillis;

public class Level2 extends AppCompatActivity {
    TextView textView, mtextField;
    Button left, right, center;
    public static int score = 0;
    String clicked;
    Random rgenerate;
    MediaPlayer mp, mp1,mpn;
    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    int i1, i2, i, x = 3000;

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

    ;

    @Override
    public void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2);
        Intent intent = getIntent();
        textView = findViewById(R.id.text);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        center = findViewById(R.id.center);
        mtextField = findViewById(R.id.mTextView);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.soundleft);
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.lose);
        mpn = MediaPlayer.create(getApplicationContext(), R.raw.nextlevel);
        score = Integer.parseInt(intent.getStringExtra(key.SCORE));
        rgenerate = new Random();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setProgress(i);
        textView.setText(String.valueOf(score));
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
                startActivity(new Intent(Level2.this, Bakwas.class)
                        .putExtra(key.SCORE, String.valueOf(score)));
                Level2.this.finish();
            }
        }.start();
        fun();
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if (clicked.equals("Left")) {
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun();
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else if (clicked.equals("Right") && score >= 40) {
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun();
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else {
                    mp1.start();
                    countDownTimer.cancel();
                    progressBar.setProgress(100);
                    startActivity(new Intent(Level2.this, Bakwas.class)
                            .putExtra(key.SCORE, String.valueOf(score)));
                    Level2.this.finish();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if (clicked.equals("Right") && score < 20) {
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun();
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else if (clicked.equals("Left") && score >= 40) {
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun();
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else {
                    mp1.start();
                    countDownTimer.cancel();
                    progressBar.setProgress(100);
                    startActivity(new Intent(Level2.this, Bakwas.class)
                            .putExtra(key.SCORE, String.valueOf(score)));
                    Level2.this.finish();
                }
            }
        });
        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if (clicked.equals("center") && score < 20) {
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun();
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else if (clicked.equals("center") && score >= 40) {
                    score++;
                    textView.setText(String.valueOf(score));
                    countDownTimer.cancel();
                    fun2();
                    fun();
                    countDownTimer.start();
                    progressBar.setProgress(0);
                } else {
                    mp1.start();
                    countDownTimer.cancel();
                    progressBar.setProgress(100);
                    startActivity(new Intent(Level2.this, Bakwas.class)
                            .putExtra(key.SCORE, String.valueOf(score)));
                    Level2.this.finish();
                }
            }
        });
    }

    void fun() {
        right.setText("");
        left.setText("");
        center.setText("");
        i = 0;
        i1 = rgenerate.nextInt(3);
        i2 = rgenerate.nextInt(3);
        if (i1 == 0) {             //left
            if (i2 == 0) {
                left.setText("Left");
                clicked = "Left";
            } else if (i2 == 1) {
                left.setText("Right");
                clicked = "Right";
            } else if (i2 == 2) {
                left.setText("center");
                clicked = "center";
            }
        } else if (i1 == 1) { //right
            if (i2 == 0) {
                right.setText("Left");
                clicked = "Left";
            } else if (i2 == 1) {
                right.setText("Right");
                clicked = "Right";
            } else if (i2 == 2) {
                right.setText("center");
                clicked = "center";
            }

        } else if (i1 == 2) {                   //center
            if (i2 == 0) {
                center.setText("Left");
                clicked = "Left";
            } else if (i2 == 1) {
                center.setText("Right");
                clicked = "Right";
            } else if (i2 == 2) {
                center.setText("center");
                clicked = "center";
            }
        }

    }

    void fun2() {
        if (score == 20) {
            mpn.start();
            countDownTimer.cancel();
            startActivity(new Intent(Level2.this, Level3_pre.class)
                    .putExtra(key.SCORE, String.valueOf(score)));
            Level2.this.finish();
        }
        else if (score==50){
            countDownTimer.cancel();
            mpn.start();
            startActivity(new Intent(Level2.this, Reverse3.class)
                    .putExtra(key.SCORE, String.valueOf(score)));
            Level2.this.finish();

        }
    }
}