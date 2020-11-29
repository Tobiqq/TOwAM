package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private ArrayList<String> listplayer1;
    private ArrayList<String> listplayer2;
    List<Player> listsecond = new ArrayList<>();
    List<Player> listfirst = new ArrayList<>();


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
        tabButtons[5] = (Button) findViewById(R.id.player7);
        tabButtons[6] = (Button) findViewById(R.id.player8);
        tabButtons[7] = (Button) findViewById(R.id.player9);
        tabButtons[8] = (Button) findViewById(R.id.player10);
        tabButtons[9] = (Button) findViewById(R.id.player11);


        Player1ListView = (ListView) findViewById(R.id.listView4);
        Player2ListView = (ListView) findViewById(R.id.listView5);
        tab = new String[10];
        list1 = new ArrayList<String>();
        HashMap<String, String> temp = new HashMap<String, String>();
        list2 = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> temp2 = new HashMap<String, String>();


        Intent in = getIntent();
        final String teamname1 = in.getStringExtra("team1");
        final String teamname2 = in.getStringExtra("team2");
        final Integer position = getIntent().getExtras().getInt("position");
        TextView team1 = (TextView) findViewById(R.id.home);
        TextView team2 = (TextView) findViewById(R.id.guest);
        team1.setText(teamname1);
        team2.setText(teamname2);



        listplayer1 = new ArrayList<String>();
        listplayer2 = new ArrayList<String>();
        listplayer1 = in.getStringArrayListExtra("team1players");
        listplayer2 = in.getStringArrayListExtra("team2players");


        for (int i = 0; i < listplayer1.size(); i++){
            Player player = new Player(listplayer1.get(i));
            listfirst.add(player);
        }

        for (int i = 0; i < listplayer2.size(); i++){
            Player player = new Player(listplayer2.get(i));
            listsecond.add(player);
        }



        int j = 0;
        for (int i = 0; i < 5; i++){
            if(j > listplayer1.size()-1){

            }else{
                tab[i] = listplayer1.get(i);
            }
            tabButtons[i].setText(tab[i]);
            j++;
        }

        int k = 0;
        for (int z = 5; z < 10; z++){
            if(k > listplayer2.size()-1){

            }else{
                tab[z] = listplayer2.get(z-5);
            }
            tabButtons[z].setText(tab[z]);
            k++;
        }


        Button btn = (Button) findViewById(R.id.player6);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), NinethActivity.class);
                in.putExtra("team1", teamname1);
                in.putExtra("team2", teamname2);
                in.putExtra("position", position);
                in.putExtra("team1players", listplayer1);
                in.putExtra("team2players", listplayer2);
                startActivity(in);
            }
        });

        Button btn2 = (Button) findViewById(R.id.player12);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), NinethActivity.class);
                in.putExtra("team1", teamname1);
                in.putExtra("team2", teamname2);
                in.putExtra("position", position);
                in.putExtra("team1players", listplayer1);
                in.putExtra("team2players", listplayer2);
                startActivity(in);
            }
        });

        Button bReb = (Button) findViewById(R.id.Rebound);
        bReb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listfirst.get(0).addrebound();
                int temp = listfirst.get(0).getreb();
                Log.i("errplay", String.valueOf(temp));
            }
        });
    }
}

