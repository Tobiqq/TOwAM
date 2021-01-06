package com.example.basketballmanagerv3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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
import java.util.List;

public class AddGameActivity extends AppCompatActivity {

    private Spinner spinner, spinner2, spinner3;

    Button Savebutton, Cancelbutton;
    Button[] tabButtons = new Button[4];
    List<Button> tabButtons2 = new ArrayList<>();


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
/*        spinner3 = findViewById(R.id.chooseleague);*/

        list.add("--Choose Team--");


        tabButtons[0] = findViewById(R.id.one);
        tabButtons[1] = findViewById(R.id.two);
        tabButtons[2] = findViewById(R.id.three);
        tabButtons[3] = findViewById(R.id.four);

        tabButtons2.add(tabButtons[0]);
        tabButtons2.add(tabButtons[1]);
        tabButtons2.add(tabButtons[2]);
        tabButtons2.add(tabButtons[3]);

        tabButtons2.get(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.clear();
                for (int i = 0; i <= 3; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(0).setSelected(true);

                if (tabButtons2.get(0).isSelected()){
                    tabButtons2.get(0).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(0).setTextColor(Color.BLACK);
                }
                final ConnectionsClass conect = new ConnectionsClass();
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();

                        if(tabButtons2.get(0).isSelected() == true){
                            ResultSet teamnameres = statement.executeQuery("SELECT teamname FROM Teams WHERE league = '1 Liga Mężczyzn'");
                            while(teamnameres.next()){
                                String temp = teamnameres.getString("teamname");
                                list.add(temp);
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        tabButtons2.get(1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.clear();
                for (int i = 0; i <= 3; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(1).setSelected(true);

                if (tabButtons2.get(1).isSelected()){
                    tabButtons2.get(1).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(1).setTextColor(Color.BLACK);
                }
                final ConnectionsClass conect = new ConnectionsClass();
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();

                        if(tabButtons2.get(1).isSelected() == true){
                            ResultSet teamnameres = statement.executeQuery("SELECT teamname FROM Teams WHERE league = '2 Liga Mężczyzn'");
                            while(teamnameres.next()){
                                String temp = teamnameres.getString("teamname");
                                list.add(temp);
                            }
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        tabButtons2.get(2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.clear();
                for (int i = 0; i <= 3; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(2).setSelected(true);

                if (tabButtons2.get(2).isSelected()){
                    tabButtons2.get(2).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(2).setTextColor(Color.BLACK);
                }
                final ConnectionsClass conect = new ConnectionsClass();
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();

                        if(tabButtons2.get(2).isSelected() == true){
                            ResultSet teamnameres = statement.executeQuery("SELECT teamname FROM Teams WHERE league = '3 Liga Mężczyzn'");
                            while(teamnameres.next()){
                                String temp = teamnameres.getString("teamname");
                                list.add(temp);
                            }
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        tabButtons2.get(3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.clear();
                for (int i = 0; i <= 3; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(3).setSelected(true);

                if (tabButtons2.get(3).isSelected()){
                    tabButtons2.get(3).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(3).setTextColor(Color.BLACK);
                }
                final ConnectionsClass conect = new ConnectionsClass();
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();

                        if(tabButtons2.get(3).isSelected() == true){
                            ResultSet teamnameres = statement.executeQuery("SELECT teamname FROM Teams WHERE league = 'Rozgrywki Amatorskie'");
                            while(teamnameres.next()){
                                String temp = teamnameres.getString("teamname");
                                list.add(temp);
                            }
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

/*        spinner3 = findViewById(R.id.chooseleague);
        String[] value = {"--Choose League--","1 Liga Mężczyzn","2 Liga Mężczyzn","3 Liga Mężczyzn","Rozgrywki Amatorskie"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        final ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, arrayList){
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
        arrayAdapter3.setDropDownViewResource(R.layout.style_spinner);
        spinner3.setAdapter(arrayAdapter3);*/


        final ConnectionsClass conect = new ConnectionsClass();

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



