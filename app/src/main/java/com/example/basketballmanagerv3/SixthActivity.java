package com.example.basketballmanagerv3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SixthActivity extends AppCompatActivity {

    private Spinner spinner;
    EditText teamname, teamshortcut, teamleague;
    Button Savebutton, Cancelbutton;
    FirebaseDatabase database;
    DatabaseReference refernce;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamesended);
        Activity activity;
        this.setTitle("Ended Games");

    }

}


