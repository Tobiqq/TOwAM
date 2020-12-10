package com.example.basketballmanagerv3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.Player;

import java.util.ArrayList;
import java.util.List;

public class TrackGameActivity extends AppCompatActivity {


    ListView Player1ListView;
    ListView Player2ListView;
    String[] tab;

    Button[] tabButtons = new Button[12];
    private ArrayList<String> listplayer1;
    private ArrayList<String> listplayer2;
    List<Player> listsecond = new ArrayList<>();
    List<Player> listfirst = new ArrayList<>();
    List<Button> tabButtons2 = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_game);
        this.setTitle("Track Game!");

        tabButtons[0] = findViewById(R.id.player1);
        tabButtons[1] = findViewById(R.id.player2);
        tabButtons[2] = findViewById(R.id.player3);
        tabButtons[3] = findViewById(R.id.player4);
        tabButtons[4] = findViewById(R.id.player5);
        tabButtons[5] = findViewById(R.id.player7);
        tabButtons[6] = findViewById(R.id.player8);
        tabButtons[7] = findViewById(R.id.player9);
        tabButtons[8] = findViewById(R.id.player10);
        tabButtons[9] = findViewById(R.id.player11);

        tabButtons2.add(tabButtons[0]);
        tabButtons2.add(tabButtons[1]);
        tabButtons2.add(tabButtons[2]);
        tabButtons2.add(tabButtons[3]);
        tabButtons2.add(tabButtons[4]);
        tabButtons2.add(tabButtons[5]);
        tabButtons2.add(tabButtons[6]);
        tabButtons2.add(tabButtons[7]);
        tabButtons2.add(tabButtons[8]);
        tabButtons2.add(tabButtons[9]);


        Player1ListView = findViewById(R.id.listView4);
        Player2ListView = findViewById(R.id.listView5);
        tab = new String[10];




        Intent in = getIntent();
        final String teamname1 = in.getStringExtra("team1");
        final String teamname2 = in.getStringExtra("team2");
        final String team1key = in.getStringExtra("team1key");
        final String team2key = in.getStringExtra("team2key");
        final Integer position = getIntent().getExtras().getInt("position");
        TextView team1 = findViewById(R.id.home);
        TextView team2 = findViewById(R.id.guest);
        team1.setText(teamname1);
        team2.setText(teamname2);

        listplayer1 = new ArrayList<>();
        listplayer2 = new ArrayList<>();
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



        tabButtons2.get(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(0).setSelected(true);

                if (tabButtons2.get(0).isSelected()){
                    tabButtons2.get(0).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(0).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(1).setSelected(true);

                if (tabButtons2.get(1).isSelected()){
                    tabButtons2.get(1).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(1).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(2).setSelected(true);

                if (tabButtons2.get(2).isSelected()){
                    tabButtons2.get(2).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(2).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(3).setSelected(true);

                if (tabButtons2.get(3).isSelected()){
                    tabButtons2.get(3).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(3).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(4).setSelected(true);

                if (tabButtons2.get(4).isSelected()){
                    tabButtons2.get(4).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(4).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(5).setSelected(true);

                if (tabButtons2.get(5).isSelected()){
                    tabButtons2.get(5).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(5).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(6).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(6).setSelected(true);

                if (tabButtons2.get(6).isSelected()){
                    tabButtons2.get(6).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(6).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(7).setSelected(true);

                if (tabButtons2.get(7).isSelected()){
                    tabButtons2.get(7).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(7).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(8).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++){
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(8).setSelected(true);

                if (tabButtons2.get(8).isSelected()){
                    tabButtons2.get(8).setTextColor(Color.GREEN);
                }else{
                    tabButtons2.get(8).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(9).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 9; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(9).setSelected(true);

                if (tabButtons2.get(9).isSelected()) {
                    tabButtons2.get(9).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(9).setTextColor(Color.BLACK);
                }
            }
        });

        Button change1 = findViewById(R.id.player6);
        change1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), NinethActivity.class);
                in.putExtra("team1", teamname1);
                in.putExtra("team2", teamname2);
                in.putExtra("position", position);
                in.putExtra("team1players", listplayer1);
                in.putExtra("team2players", listplayer2);
                in.putExtra("team2players", listplayer2);
                in.putExtra("listfirst1", String.valueOf(listfirst));
                in.putExtra("listsecond2", String.valueOf(listsecond));
                startActivity(in);
            }
        });
        Button change2 = findViewById(R.id.player12);
        change2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), NinethActivity.class);
                in.putExtra("team1", teamname1);
                in.putExtra("team2", teamname2);
                in.putExtra("position", position);
                in.putExtra("team1players", listplayer1);
                in.putExtra("team2players", listplayer2);
                in.putExtra("listfirst1", String.valueOf(listfirst));
                in.putExtra("listsecond2", String.valueOf(listsecond));
                startActivity(in);
            }

        });


        Button bReb = findViewById(R.id.Rebound);
        bReb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getText()){
                                listfirst.get(j).addrebound();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getreb()));
/*                                final int pp = j;

                                String path = "teams/"+team1key+"/players/";
                                Query reference = FirebaseDatabase.getInstance().getReference(path).orderByChild("playername").equalTo(listfirst.get(j).getname());
                                Query reference2 = FirebaseDatabase.getInstance().getReference("teams").child(team1key).child("players");
                                reference.addListenerForSingleValueEvent(new ValueEventListener(){
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                            String playern = dataSnapshot.child("playername").getValue(String.class);
                                            if(playern == listfirst.get(pp).getname()){
                                                player1key = dataSnapshot.getKey();

                                        }
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });



                                database = FirebaseDatabase.getInstance();
                                refernce = database.getReference("teams/"+ team1key +"/players/"+ player1key+"/rebound");
                                String name = listfirst.get(j).getname();
                                int mno = 0;
                                String number = String.valueOf(mno);
                                int number2 = listfirst.get(j).getreb();
                                CollectHelperClass collect = new CollectHelperClass(name,number2,number);
                                refernce.push().setValue(collect);
                                Context context = getApplicationContext();
                                Toast.makeText(context, "Data added succesfully!!", Toast.LENGTH_SHORT).show();*/
                            }
                        }

                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getText()){
                                listsecond.get(k).addrebound();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getreb()));
                            }
                        }
                    }else{}
                }
            }
        });



        Button bSteal = findViewById(R.id.Steal);
        bSteal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getText()){
                                listfirst.get(j).addsteal();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getsteal()));
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getText()){
                                listsecond.get(k).addsteal();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getsteal()));
                            }
                        }
                    }else{}
                }
            }
        });

        Button bAsis = findViewById(R.id.Asist);
        bAsis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getText()){
                                listfirst.get(j).addasist();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getasis()));
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getText()){
                                listsecond.get(k).addasist();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getasis()));
                            }
                        }
                    }else{}
                }
            }
        });

        Button b2points = findViewById(R.id.Points2);
        b2points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getText()){
                                listfirst.get(j).add2points();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).get2points()));
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getText()){
                                listsecond.get(k).add2points();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).get2points()));
                            }
                        }
                    }else{}
                }
            }
        });

        Button b3points = findViewById(R.id.Points3);
        b3points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getText()){
                                listfirst.get(j).add3points();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).get3points()));
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getText()){
                                listsecond.get(k).add3points();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).get3points()));
                            }
                        }
                    }else{}
                }
            }
        });

    }
}

