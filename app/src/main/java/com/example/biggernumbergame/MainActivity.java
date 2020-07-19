package com.example.biggernumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView score;
    int scoreCount = 0;
    int totalAttempt = 3;
    int num1 = 0;
    int num2 = 0;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.leftBtn);
        btn2 = findViewById(R.id.rightBtn);
        score = findViewById(R.id.score);

        rand = new Random();

        changeNum();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 > num2){
                    increaseScore();

                }else {
                    decreaseScore();
                }
                changeNum();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num2 > num1){
                    increaseScore();
                }else {
                    decreaseScore();
                }
                changeNum();
            }
        });
    }
    private void changeNum(){
        Random rand = new Random();
        num1 = rand.nextInt(1000);
        num2 = rand.nextInt(1000);
        btn1.setText(num1+"");
        btn2.setText(num2+"");
    }
    private void increaseScore(){
        scoreCount++;
        score.setText("Your Score is : "+scoreCount+"");
    }
    private void decreaseScore(){
        totalAttempt--;
        Toast.makeText(getApplicationContext(), "Wrong answer attempt left : "+totalAttempt, Toast.LENGTH_LONG).show();
        if (totalAttempt == 0) {
            resetScore();
        }
    }
    private void resetScore(){
        scoreCount = 0;
        totalAttempt = 3;
        score.setText("Your Score is : "+scoreCount+"");
        Toast.makeText(getApplicationContext(), "Score Reset Try Again", Toast.LENGTH_LONG).show();
    }
}
