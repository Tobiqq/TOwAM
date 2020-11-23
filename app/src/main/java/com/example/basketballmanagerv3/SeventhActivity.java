package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SeventhActivity extends AppCompatActivity {

    private Spinner spinner;
    FirebaseDatabase database;
    private Activity activity;
    ListView Player1ListView;
    ListView Player2ListView;
    private ArrayList<String> list1;
    String[] tab;
    private ArrayList<HashMap<String, String>> list2;
    String team1key;
    String team2key;
    Button[] tabButtons = new Button[12];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackgamelayout);
        Activity activity;
        this.setTitle("Track Game!");

        tabButtons[0] = (Button) findViewById(R.id.player1);
        tabButtons[1] = (Button) findViewById(R.id.player2);
        tabButtons[2] = (Button) findViewById(R.id.player3);
        tabButtons[3] = (Button) findViewById(R.id.player4);
        tabButtons[4] = (Button) findViewById(R.id.player5);
        tabButtons[5] = (Button) findViewById(R.id.player6);
        tabButtons[6] = (Button) findViewById(R.id.player7);
        tabButtons[7] = (Button) findViewById(R.id.player8);
        tabButtons[8] = (Button) findViewById(R.id.player9);
        tabButtons[9] = (Button) findViewById(R.id.player10);
        tabButtons[10] = (Button) findViewById(R.id.player11);
        tabButtons[11] = (Button) findViewById(R.id.player12);

        Player1ListView = (ListView) findViewById(R.id.listView4);
        Player2ListView = (ListView) findViewById(R.id.listView5);
        tab = new String[12];
        list1 = new ArrayList<String>();
        HashMap<String, String> temp = new HashMap<String, String>();
        list2 = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> temp2 = new HashMap<String, String>();


        Intent in = getIntent();
        String teamname1 = in.getStringExtra("team1");
        String teamname2 = in.getStringExtra("team2");
        Integer position = getIntent().getExtras().getInt("position");
        TextView team1 = (TextView) findViewById(R.id.home);
        TextView team2 = (TextView) findViewById(R.id.guest);
        team1.setText(teamname1);
        team2.setText(teamname2);




        Query reference = FirebaseDatabase.getInstance().getReference("teams").orderByChild("teamname").equalTo(teamname1);

        reference.addListenerForSingleValueEvent(new ValueEventListener(){
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    team1key = childSnapshot.getKey();
                    Log.i("err", team1key);
                }
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        Query reference2 = FirebaseDatabase.getInstance().getReference("teams").orderByChild("teamname").equalTo(teamname2);

        reference2.addListenerForSingleValueEvent(new ValueEventListener(){
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    team2key = childSnapshot.getKey();
                    Log.i("err", team2key);
                }
                Query reference3 = FirebaseDatabase.getInstance().getReference("teams").child(team2key).child("players");
                reference3.addValueEventListener(new ValueEventListener() {
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String playern = snapshot.child("playername").getValue(String.class);
                            list1.add(playern);
                            Log.i("errplay", playern);
                        }
                        int j = 0;
                        for (int i = 0; i < tab.length; i++){
                            if(j > list1.size()-1){
                                tab[i] = "elo";
                            }else{
                                tab[i] = list1.get(i);
                            }
                            tabButtons[i].setText(tab[i]);
                            j++;
                        }
                }

                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

