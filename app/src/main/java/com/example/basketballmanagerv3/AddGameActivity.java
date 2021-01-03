package com.example.basketballmanagerv3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddGameActivity extends AppCompatActivity {

    private Spinner spinner, spinner2;

    Button Savebutton, Cancelbutton;


    final ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gane_activity);
        this.setTitle("Add Game");

        Savebutton = findViewById(R.id.Savebutton);
        Cancelbutton = findViewById(R.id.Cancelbutton);

        spinner = findViewById(R.id.hostteamname);
        spinner2 = findViewById(R.id.guestteamname);

        list.add("--Choose Team--");

        final ConnectionsClass conect = new ConnectionsClass();
        if(conect.CONN() != null){
            Statement statement = null;
            try {
                statement = conect.CONN().createStatement();
                ResultSet teamnameres = statement.executeQuery("SELECT teamname FROM Teams");
                while(teamnameres.next()){
                    String temp = teamnameres.getString("teamname");
                    list.add(temp);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

/*        list.add("--Choose Team--");
        final ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.team_list_item2, list);
        DatabaseReference referance = FirebaseDatabase.getInstance().getReference().child("teams");
        referance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    list.add(snapshot.child("teamname").getValue(String.class));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, list){
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
        final ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, list){
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
        arrayAdapter2.setDropDownViewResource(R.layout.style_spinner);
        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);


        Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hostname = spinner.getSelectedItem().toString();
                String guestname = spinner2.getSelectedItem().toString();
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();
                        ResultSet idgame = statement.executeQuery("SELECT COUNT (id_game) AS total FROM Games");
                        int idgamecount = 0;
                        int temp1 = 0;
                        int temp2 = 0;
                        while(idgame.next()){
                            idgamecount = idgame.getInt("total");
                            idgamecount += 1;
                        }
                        ResultSet hostnameid = statement.executeQuery("SELECT id_team FROM Teams WHERE teamname='"+hostname+"'");
                        while(hostnameid.next()){
                            temp1 = Integer.parseInt(hostnameid.getObject(1).toString());
                        }
                        ResultSet guestnameid = statement.executeQuery("SELECT id_team FROM Teams WHERE teamname='"+guestname+"'");
                        while(guestnameid.next()){
                            temp2 = Integer.parseInt(guestnameid.getObject(1).toString());
                        }
                        statement.executeUpdate("SET IDENTITY_INSERT Games ON");
                        ResultSet result = statement.executeQuery("INSERT INTO Games (id_game, id_team_home, id_team_guest, game_state) VALUES"+"('" +idgamecount+ "'," + "'" +temp1+ "'," + "'" +temp2+"'," + "1)");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                Context context = getApplicationContext();
                Toast.makeText(context, "Data added succesfully!", Toast.LENGTH_SHORT).show();
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



