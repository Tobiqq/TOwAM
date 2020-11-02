package com.example.basketballmanagerv3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private Spinner spinner;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamspopup);

        this.setTitle("Add Team");



        spinner = findViewById(R.id.teamleague);
        String[] value = {"--Choose Your League--","1 Liga Mężczyzn","2 Liga Mężczyzn","3 Liga Mężczyzn","Rozgrywki Amatorskie"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.itemleague,R.id.tvLeague, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.style_spinner);
        spinner.setAdapter(arrayAdapter);

/*        Spinner spinner = findViewById(R.id.teamleague);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.teamleague, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/

    }
}


