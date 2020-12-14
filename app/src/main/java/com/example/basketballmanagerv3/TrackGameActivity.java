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

    Button[] tabButtons = new Button[25];
    private ArrayList<String> listplayer1;
    private ArrayList<String> listplayer2;
    private ArrayList<String> listplayer1number;
    private ArrayList<String> listplayer2number;
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
        tabButtons[5] = findViewById(R.id.player6);
        tabButtons[6] = findViewById(R.id.player7);
        tabButtons[7] = findViewById(R.id.player8);
        tabButtons[8] = findViewById(R.id.player9);
        tabButtons[9] = findViewById(R.id.player10);
        tabButtons[10] = findViewById(R.id.player11);
        tabButtons[11] = findViewById(R.id.player12);
        tabButtons[12] = findViewById(R.id.player13);
        tabButtons[13] = findViewById(R.id.player14);
        tabButtons[14] = findViewById(R.id.player15);
        tabButtons[15] = findViewById(R.id.player16);
        tabButtons[16] = findViewById(R.id.player17);
        tabButtons[17] = findViewById(R.id.player18);
        tabButtons[18] = findViewById(R.id.player19);
        tabButtons[19] = findViewById(R.id.player20);
        tabButtons[20] = findViewById(R.id.player21);
        tabButtons[21] = findViewById(R.id.player22);
        tabButtons[22] = findViewById(R.id.player23);
        tabButtons[23] = findViewById(R.id.player24);


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
        tabButtons2.add(tabButtons[10]);
        tabButtons2.add(tabButtons[11]);
        tabButtons2.add(tabButtons[12]);
        tabButtons2.add(tabButtons[13]);
        tabButtons2.add(tabButtons[14]);
        tabButtons2.add(tabButtons[15]);
        tabButtons2.add(tabButtons[16]);
        tabButtons2.add(tabButtons[17]);
        tabButtons2.add(tabButtons[18]);
        tabButtons2.add(tabButtons[19]);
        tabButtons2.add(tabButtons[20]);
        tabButtons2.add(tabButtons[21]);
        tabButtons2.add(tabButtons[22]);
        tabButtons2.add(tabButtons[23]);


        Player1ListView = findViewById(R.id.listView4);
        Player2ListView = findViewById(R.id.listView5);
        tab = new String[25];




        Intent in = getIntent();
        final String teamname1 = in.getStringExtra("team1");
        final String teamname2 = in.getStringExtra("team2");
        final Integer position = getIntent().getExtras().getInt("position");
        TextView team1 = findViewById(R.id.home);
        TextView team2 = findViewById(R.id.guest);
        team1.setText(teamname1);
        team2.setText(teamname2);

        listplayer1 = new ArrayList<>();
        listplayer2 = new ArrayList<>();
        listplayer1 = in.getStringArrayListExtra("team1players");
        listplayer2 = in.getStringArrayListExtra("team2players");

        listplayer1number = new ArrayList<>();
        listplayer2number = new ArrayList<>();
        listplayer1number = in.getStringArrayListExtra("team1playersnb");
        listplayer2number = in.getStringArrayListExtra("team2playersnb");



        for (int i = 0; i < listplayer1.size(); i++){
            Player player = new Player(listplayer1.get(i), Integer.parseInt(listplayer1number.get(i)));
            listfirst.add(player);
        }

        for (int i = 0; i < listplayer2.size(); i++){
            Player player = new Player(listplayer2.get(i), Integer.parseInt(listplayer2number.get(i)));
            listsecond.add(player);
        }

        int j = 0;
        for (int i = 0; i < 12; i++){
            if(j > listplayer1number.size()-1){

            }else{
                tab[i] = listplayer1number.get(i);
            }
            if(tab[i]==null){
                tabButtons[i].setVisibility(View.INVISIBLE);
            }else
            tabButtons[i].setText(tab[i]);
            j++;
        }


        int k = 0;
        for (int z = 12; z < 24; z++){
            if(k > listplayer2number.size()-1){

            }else{
                tab[z] = listplayer2number.get(z-12);
            }
            if(tab[z]==null){
                tabButtons[z].setVisibility(View.INVISIBLE);
            }else
            tabButtons[z].setText(tab[z]);
            k++;
        }



        tabButtons2.get(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++){
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
                for (int i = 0; i <= 23; i++) {
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

        tabButtons2.get(10).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(10).setSelected(true);

                if (tabButtons2.get(10).isSelected()) {
                    tabButtons2.get(10).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(10).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(11).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(11).setSelected(true);

                if (tabButtons2.get(11).isSelected()) {
                    tabButtons2.get(11).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(11).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(12).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(12).setSelected(true);

                if (tabButtons2.get(12).isSelected()) {
                    tabButtons2.get(12).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(12).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(13).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(13).setSelected(true);

                if (tabButtons2.get(13).isSelected()) {
                    tabButtons2.get(13).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(13).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(14).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(14).setSelected(true);

                if (tabButtons2.get(14).isSelected()) {
                    tabButtons2.get(14).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(14).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(15).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(15).setSelected(true);

                if (tabButtons2.get(15).isSelected()) {
                    tabButtons2.get(15).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(15).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(16).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(16).setSelected(true);

                if (tabButtons2.get(16).isSelected()) {
                    tabButtons2.get(16).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(16).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(17).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(17).setSelected(true);

                if (tabButtons2.get(17).isSelected()) {
                    tabButtons2.get(17).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(17).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(18).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(18).setSelected(true);

                if (tabButtons2.get(18).isSelected()) {
                    tabButtons2.get(18).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(18).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(19).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(19).setSelected(true);

                if (tabButtons2.get(19).isSelected()) {
                    tabButtons2.get(19).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(19).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(20).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(20).setSelected(true);

                if (tabButtons2.get(20).isSelected()) {
                    tabButtons2.get(20).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(20).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(21).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(21).setSelected(true);

                if (tabButtons2.get(21).isSelected()) {
                    tabButtons2.get(21).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(21).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(22).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(22).setSelected(true);

                if (tabButtons2.get(22).isSelected()) {
                    tabButtons2.get(22).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(22).setTextColor(Color.BLACK);
                }
            }
        });

        tabButtons2.get(23).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 23; i++) {
                    tabButtons2.get(i).setSelected(false);
                    tabButtons2.get(i).setTextColor(Color.BLACK);
                }
                tabButtons2.get(23).setSelected(true);

                if (tabButtons2.get(23).isSelected()) {
                    tabButtons2.get(23).setTextColor(Color.GREEN);
                } else {
                    tabButtons2.get(23).setTextColor(Color.BLACK);
                }
            }
        });



        Button bReb = findViewById(R.id.Rebound_off);
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
                            if(listfirst.get(j).getnumber() == Integer.parseInt((String) tabButtons2.get(i).getText())){
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

