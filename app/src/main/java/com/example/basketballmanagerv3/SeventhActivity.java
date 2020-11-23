package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SeventhActivity extends AppCompatActivity {

    private Spinner spinner;
    EditText teamname, teamshortcut, teamleague;
    Button Savebutton, Cancelbutton;
    FirebaseDatabase database;
    DatabaseReference refernce;
    private Activity activity;
    ListView Player1ListView;
    ListView Player2ListView;
    private ArrayList<String> list1;
    private ArrayList<HashMap<String, String>> list2;
    String team1key;
    String team2key;
    String tempxxx;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackgamelayout);
        Activity activity;
        this.setTitle("Track Game!");



        Player1ListView = (ListView) findViewById(R.id.listView4);
        Player2ListView = (ListView) findViewById(R.id.listView5);
        list1 = new ArrayList<String>();
        HashMap<String, String> temp = new HashMap<String, String>();
        list2 = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> temp2 = new HashMap<String, String>();


        Intent in = getIntent();
        String teamname1 = in.getStringExtra("team1");
        String teamname2 = in.getStringExtra("team2");
        final String position = getIntent().getExtras().getString("position");
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
                    tempxxx="\""+team2key+"\"";
                    Log.i("err", tempxxx);
                }
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

/*        Query reference3 = FirebaseDatabase.getInstance().getReference("teams").child("-MLcI3dnmaAK7_0XNOzl").child("players").child("-MMlvHr8EV-xN91bLA1B");
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String playern = snapshot.child("playername").getValue(String.class);
                    list1.add(playern);
                    Log.i("errplay", playern);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });*/
    }
}

