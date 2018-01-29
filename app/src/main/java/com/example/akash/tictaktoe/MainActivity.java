package com.example.akash.tictaktoe;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int RED = 0xffFF8080;
    private static final int BLUE = 0xff00FF00;
    int Player = 0, Count = 0;
    boolean GameOver = false;
    int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[][] solutions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
    };
    Button n;
    ObjectAnimator blink;
    TextView Player1, Player2;
    TextView results;

    public void startGame(View view) {
        blink.setDuration(0);


        if (GameOver == true) {



        }
        else {
            Player1.setBackground(getResources().getDrawable(R.drawable.bordor));
            Player2.setBackground(getResources().getDrawable(R.drawable.bordor));

            Button b = (Button)findViewById(view.getId());
            if (arr[Integer.parseInt(view.getTag().toString()) - 1] == 0) {

                Count++;
                if (Count % 2 == 0)
                    Player = 2;
                else
                    Player = 1;
                arr[Integer.parseInt(view.getTag().toString()) - 1] = Player;
                b.setText("P"+Player);

                for (int i = 0; i < 8; i++) {
                    if (arr[solutions[i][0]] == arr[solutions[i][1]] && arr[solutions[i][2]] == arr[solutions[i][1]]
                            && arr[solutions[i][0]] != 0) {

                        GameOver = true;
                        results = (TextView)findViewById(R.id.result);
                        results.setText("Player " + Player + " won...!!!");
                        blink.setDuration(0);
                        n.setVisibility(View.VISIBLE);
                        break;

                    }
                }

            }
            if(Player == 1)
                blink(2);
            else
                blink(1);


        }

    }

    public void newGame(View view) {

        GameOver = false;

        for (int i = 0; i < 9; i++) {
            arr[i] = 0;
        }
        Button b = (Button) findViewById(R.id.b1);
        b.setText("");
        b = (Button) findViewById(R.id.b2);b.setText("");
        b = (Button) findViewById(R.id.b3);b.setText("");
        b = (Button) findViewById(R.id.b4);b.setText("");
        b = (Button) findViewById(R.id.b5);b.setText("");
        b = (Button) findViewById(R.id.b6);b.setText("");
        b = (Button) findViewById(R.id.b7);b.setText("");
        b = (Button) findViewById(R.id.b8);b.setText("");
        b = (Button) findViewById(R.id.b9);b.setText("");
        results.setText("Click here to start");
        n.setVisibility(View.INVISIBLE);
        Count = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = (Button)findViewById(R.id.NewGame);
        n.setVisibility(View.INVISIBLE);

        Player1 = (TextView)findViewById(R.id.textView);
        Player2 = (TextView)findViewById(R.id.textView2);
        blink(1);

    }

    public void blink(int P) {

        if (P == 1)
            blink = ObjectAnimator.ofInt(Player1, "backgroundColor", RED, BLUE);
        else
            blink = ObjectAnimator.ofInt(Player2, "backgroundColor", RED, BLUE);
        blink.setDuration(1000);
        blink.setEvaluator(new ArgbEvaluator());
        blink.setRepeatCount(10);
        blink.setRepeatMode(ValueAnimator.RESTART);
        blink.start();

    }


}
