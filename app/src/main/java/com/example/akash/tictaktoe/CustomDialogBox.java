package com.example.akash.tictaktoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CustomDialogBox extends Dialog implements android.view.View.OnClickListener {

    int Player;
    public Dialog d;
    public Button NewGame;

    public CustomDialogBox(@NonNull Context context) {
        super(context);
    }

    public CustomDialogBox(@NonNull Context context, int Player) {
        super(context);
        this.Player = Player;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_box);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        NewGame = (Button)findViewById(R.id.newgame);
    }

    public void newGame(View view) {

        

    }

    @Override
    public void onClick(View v) {

    }
}
