package com.example.kishan.myrpsgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissor;
    TextView your_score, cpu_score;
    ImageView iv_me, iv_cpu;
    String myChoice, cpuChoice, result,position;

    int myScore = 0, compScore = 0, limit = 0;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissor = (Button) findViewById(R.id.b_scissor);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        your_score = (TextView) findViewById(R.id.your_score);
        cpu_score = (TextView) findViewById(R.id.cpu_score);

        r = new Random();


        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });

        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Scissor";
                iv_me.setImageResource(R.drawable.scissor);
                calculate();
            }
        });

    }

    public void calculate() {

        if (limit <5) {
            int cpu = r.nextInt(3);
            if (cpu == 0) {
                cpuChoice = "Rock";
                iv_cpu.setImageResource(R.drawable.rock);
            } else if (cpu == 1) {
                cpuChoice = "Paper";
                iv_cpu.setImageResource(R.drawable.paper);

            } else if (cpu == 2) {
                cpuChoice = "Scissor";
                iv_cpu.setImageResource(R.drawable.scissor);
            }

            if (myChoice.equals("Rock") && cpuChoice.equals("Paper")) {
                result = "You Lose";
                compScore = compScore + 1;
                limit=limit+1;
            } else if (myChoice.equals("Rock") && cpuChoice.equals("Scissor")) {
                result = "You Win";
                myScore = myScore + 1;
                limit=limit+1;
            } else if (myChoice.equals("Paper") && cpuChoice.equals("Rock")) {
                result = "You Win";
                myScore = myScore + 1;
                limit=limit+1;
            } else if (myChoice.equals("Paper") && cpuChoice.equals("Scissor")) {
                result = "You Lose";
                compScore = compScore + 1;
                limit=limit+1;
            } else if (myChoice.equals("Scissor") && cpuChoice.equals("Paper")) {
                result = "You Win";
                myScore = myScore + 1;
                limit=limit+1;
            } else if (myChoice.equals("Scissor") && cpuChoice.equals("Rock")) {
                result = "You Lose";
                compScore = compScore + 1;
                limit=limit+1;
            } else if (myChoice.equals("Rock") && cpuChoice.equals("Rock")) {
                result = "Tie";
            } else if (myChoice.equals("Scissor") && cpuChoice.equals("Scissor")) {
                result = "Tie";
            } else if (myChoice.equals("Paper") && cpuChoice.equals("Paper")) {
                result = "Tie";
            }

            String myvalue = Integer.toString(myScore);
            String cpuvalue = Integer.toString(compScore);

            your_score.setText(myvalue);
            cpu_score.setText(cpuvalue);

            if(myScore>compScore){
                position="WINNER";
            }else if(myScore<compScore){
                position="LOSE";
            }

            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } else {

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("your are " + position + " & score : " + myScore);
            builder.setMessage("Do want to Try Again");

            builder.setPositiveButton("YES!!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i=new Intent(MainActivity.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
            });
                    builder.setNegativeButton("NO!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                          finish();
                        }
                    });
            builder.create().show();

        }
    }
}

