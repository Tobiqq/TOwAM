package com.example.basketballmanagerv3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class AddPlayerActivity extends AppCompatActivity {


    Spinner spinner;
    EditText playername, playernumber;
    Button Savebutton, Cancelbutton;
    FirebaseDatabase database;
    DatabaseReference refernce;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_popup);
        this.setTitle("Add Player");


        spinner = findViewById(R.id.playerposition);
        String[] value = {"--Choose Player Posiotion--","PG","SG","SF","PF","C"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, arrayList){
            @SuppressLint("ResourceAsColor")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green3));
                }
                else {
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green));
                }
                return view;
            }
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @SuppressLint("ResourceAsColor")
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green3));
                }
                else {
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green));
                }
                return view;
            }
        };
        arrayAdapter.setDropDownViewResource(R.layout.style_spinner);

        spinner.setAdapter(arrayAdapter);


        playername = findViewById(R.id.playername);
        playernumber = findViewById(R.id.playernumber);

        Savebutton = findViewById(R.id.Savebutton3);
        Cancelbutton = findViewById(R.id.Cancelbutton3);

        Intent in = getIntent();
        final String position = getIntent().getExtras().getString("position");
        final String Id = in.getStringExtra("id");

        final ConnectionsClass conect = new ConnectionsClass();

        Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = playername.getText().toString();
                String number = playernumber.getText().toString();
                int number2 = Integer.parseInt(number);
                String pos = spinner.getSelectedItem().toString();
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();
                        ResultSet idteam = statement.executeQuery("SELECT COUNT (id_player) AS total FROM Players");
                        int idplayercount = 0;
                        while(idteam.next()){
                            idplayercount = idteam.getInt("total");
                            idplayercount += 1;
                        }
                        statement.executeUpdate("SET IDENTITY_INSERT Players ON");
                        ResultSet result2 = statement.executeQuery("INSERT INTO Players (id_player, id_team, player_name, position, number) VALUES('"+idplayercount+"','"+Integer.parseInt(Id)+"','" +name+"','"+pos+"','"+number2+"')");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                Context context = getApplicationContext();
                Toast.makeText(context, "Data added succesfully!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}