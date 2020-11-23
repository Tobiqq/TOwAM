package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourtActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerslayout);
        Activity activity;
        this.setTitle("Players");


        Intent in = getIntent();
        String teamname = in.getStringExtra("team");
        TextView team = (TextView) findViewById(R.id.FirstText2);
        team.setText("              " + teamname);
    }

}
