package com.example.basketballmanagerv3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.DisplayHelper;
import com.example.basketballmanagerv3.Helpers.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class TrackGameActivity extends AppCompatActivity {


    ListView Player1ListView;
    ListView Player2ListView;
    String[] tab;
    String[] tab2;

    Button[] tabButtons = new Button[25];
    private ArrayList<String> listplayer1;
    private ArrayList<String> listplayer2;
    private ArrayList<String> listplayer1number;
    private ArrayList<String> listplayer2number;
    List<Player> listsecond = new ArrayList<>();
    List<Player> listfirst = new ArrayList<>();
    List<Button> tabButtons2 = new ArrayList<>();
    ListView text;
    ListView text2;
    private ArrayList<HashMap<String, String>> list2;
    private ArrayList<HashMap<String, String>> list3;

    String actionreboff = "Offensive Rebound";
    String actionrebdeff = "Defensive Rebound";
    String action2ptsin = "Made 2pt shot";
    String action2pttry = "Miss 2pt shot";
    String action3ptin = "Made 3pt shot";
    String action3pttry = "Miss 3pt shot";
    String actionfreein = "Made freethrow shot";
    String actionfreetry = "Miss freethrow shot";
    String actionasist = "Asist";
    String actionloss = "Loss";
    String actionsteal = "Steal";
    String actionblock = "Block";






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
        tab2 = new String[25];

        text = findViewById(R.id.listView4);
        text2 = findViewById(R.id.listView5);
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();



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
                tab2[i] = listplayer1.get(i);
            }
            if(tab[i]==null){
                tabButtons[i].setVisibility(View.INVISIBLE);
            }else
            tabButtons[i].setText(tab[i]);
            tabButtons[i].setHint(tab2[i]);;
            j++;
        }


        int k = 0;
        for (int z = 12; z < 24; z++){
            if(k > listplayer2number.size()-1){

            }else{
                tab[z] = listplayer2number.get(z-12);
                tab2[z] = listplayer2.get(z-12);
            }
            if(tab[z]==null){
                tabButtons[z].setVisibility(View.INVISIBLE);
            }else
            tabButtons[z].setText(tab[z]);
            tabButtons[z].setHint(tab2[z]);;
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



        Button bReb1 = findViewById(R.id.Rebound_off);
        bReb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).addreboundoff();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getreboff()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).getreboff();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, actionreboff, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, actionreboff, temp0);
                                    }
                                });
                            }
                        }

                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).addreboundoff();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getreboff()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).getreboff();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, actionreboff, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, actionreboff, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button bReb2 = findViewById(R.id.Rebound_deff);
        bReb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).addrebounddeff();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getrebdeff()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).getrebdeff();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, actionrebdeff, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, actionrebdeff, temp0);
                                    }
                                });
                            }
                        }

                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).addrebounddeff();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getrebdeff()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).getrebdeff();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, actionrebdeff, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, actionrebdeff, temp0);
                                    }
                                });
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
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).addsteal();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getsteal()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).getsteal();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, actionsteal, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, actionsteal, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).addsteal();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getsteal()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).getsteal();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, actionsteal, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, actionsteal, temp0);
                                    }
                                });
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
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).addasist();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getasis()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).getasis();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, actionasist, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, actionasist, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).addasist();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getasis()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).getasis();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, actionasist, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, actionasist, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button b2points = findViewById(R.id.Points2in);
        b2points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).add2points();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).get2points()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).get2points();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, action2ptsin, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, action2ptsin, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).add2points();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).get2points()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).get2points();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, action2ptsin, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, action2ptsin, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button b2pointstry = findViewById(R.id.Points2try);
        b2pointstry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).add2pointstry();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).get2pointstry()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).get2pointstry();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, action2pttry, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, action2pttry, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).add2pointstry();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).get2pointstry()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).get2pointstry();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, action2pttry, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, action2pttry, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button b3points = findViewById(R.id.Points3in);
        b3points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).add3points();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).get3points()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).get3points();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, action3ptin, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, action3ptin, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).add3points();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).get3points()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).get3points();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, action3ptin, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, action3ptin, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button b3pointstry = findViewById(R.id.Points3try);
        b3pointstry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).add3pointstry();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).get3pointstry()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).get3pointstry();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, action3pttry, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, action3pttry, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).add3pointstry();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).get3pointstry()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).get3pointstry();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, action3pttry, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, action3pttry, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button bloss = findViewById(R.id.Loss);
        bloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).addloss();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getloss()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).getloss();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, actionloss, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, actionloss, temp0);
                                    }
                                });
                            }
                        }
                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).addloss();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getloss()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).getloss();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, actionloss, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, actionloss, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });

        Button bBlo = findViewById(R.id.Block);
        bBlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < tabButtons2.size(); i++){
                    if(tabButtons2.get(i).isSelected() == true){
                        for (int j = 0; j < listfirst.size(); j++){
                            if(listfirst.get(j).getname() == tabButtons2.get(i).getHint()){
                                listfirst.get(j).addblock();
                                Log.i(listfirst.get(j).getname(), String.valueOf(listfirst.get(j).getblock()));
                                final int finalJ = j;
                                final int temp0 = listfirst.get(j).getblock();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text, list2, listfirst, finalJ, actionblock, temp0);
                                text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text, list2, listfirst, finalJ, actionblock, temp0);
                                    }
                                });
                            }
                        }

                        for (int k = 0; k < listsecond.size(); k++){
                            if(listsecond.get(k).getname() == tabButtons2.get(i).getHint()){
                                listsecond.get(k).addblock();
                                Log.i(listsecond.get(k).getname(), String.valueOf(listsecond.get(k).getblock()));
                                final int finalK = k;
                                final int temp0 = listsecond.get(k).getblock();
                                final DisplayHelper helper = new DisplayHelper();
                                helper.show(TrackGameActivity.this, text2, list3, listsecond, finalK, actionblock, temp0);
                                text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        helper.delete(TrackGameActivity.this, text2, list3, listsecond, finalK, actionblock, temp0);
                                    }
                                });
                            }
                        }
                    }else{}
                }
            }
        });


        final int[] twopointsin = new int[1];
        final int[] twopointstry = new int[1];
        final int[] threepointsin = new int[1];
        final int[] threepointstry = new int[1];
        final int[] reboff = new int[1];
        final int[] rebdeff = new int[1];
        final int[] asist = new int[1];
        final int[] steal = new int[1];
        final int[] loss = new int[1];

        final Button endtracking = findViewById(R.id.End_Tracking);
        endtracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < listfirst.size()+listsecond.size(); i++) {
                    if(i < listfirst.size()){
                        twopointsin[0] = listfirst.get(i).get2points();
                        twopointstry[0] = listfirst.get(i).get2pointstry();
                        threepointsin[0] = listfirst.get(i).get3points();
                        threepointstry[0] = listfirst.get(i).get3pointstry();
                        reboff[0] = listfirst.get(i).getreboff();
                        rebdeff[0] = listfirst.get(i).getrebdeff();
                        asist[0] = listfirst.get(i).getasis();
                        steal[0] = listfirst.get(i).getsteal();
                        loss[0] = listfirst.get(i).getloss();
                    }
                    if(i >= listfirst.size()){
                        i=i+1;
                        twopointsin[0] = listsecond.get(i-listsecond.size()).get2points();
                        twopointstry[0] = listsecond.get(i-listsecond.size()).get2pointstry();
                        threepointsin[0] = listsecond.get(i-listsecond.size()).get3points();
                        threepointstry[0] = listsecond.get(i-listsecond.size()).get3pointstry();
                        reboff[0] = listsecond.get(i-listsecond.size()).getreboff();
                        rebdeff[0] = listsecond.get(i-listsecond.size()).getrebdeff();
                        asist[0] = listsecond.get(i-listsecond.size()).getasis();
                        steal[0] = listsecond.get(i-listsecond.size()).getsteal();
                        loss[0] = listsecond.get(i-listsecond.size()).getloss();
                        i=i-1;
                    }

                    final ConnectionsClass conect = new ConnectionsClass();
                    if (conect.CONN() != null) {
                        Statement statement = null;
                        Statement statement2 = null;
                        Statement statement3 = null;
                        Statement statement4 = null;
                        Statement statement5 = null;
                        try {
                            statement = conect.CONN().createStatement();
                            statement2 = conect.CONN().createStatement();
                            statement3 = conect.CONN().createStatement();
                            statement4 = conect.CONN().createStatement();
                            statement5 = conect.CONN().createStatement();

                            int idstatscount = 0;
                            int idgame = 0;
                            List<Integer> idplayer = new ArrayList<>();

                            ResultSet result = statement2.executeQuery("SELECT id_game FROM Games WHERE id_team_home = (SELECT id_team FROM Teams WHERE teamname = '"+teamname1+"')"+ "AND id_team_guest = (SELECT id_team FROM Teams WHERE teamname = '"+teamname2+"')");
                            while (result.next()) {
                                idgame = result.getInt(1);
                            }
                            ResultSet result2 = statement3.executeQuery("SELECT id_player FROM Players WHERE id_team = (SELECT id_team FROM Teams WHERE teamname = '"+teamname1+"')"+ "OR id_team = (SELECT id_team FROM Teams WHERE teamname = '"+teamname2+"')");
                            while (result2.next()) {
                                int temp = result2.getInt(1);
                                idplayer.add(temp);
                            }
                            ResultSet idstats = statement.executeQuery("SELECT COUNT (id_stats) AS total FROM Match_stats");
                            while (idstats.next()) {
                                idstatscount = idstats.getInt("total");
                                idstatscount += 1;
                                statement4.executeUpdate("SET IDENTITY_INSERT Match_stats ON");
                                statement4.executeUpdate("INSERT INTO Match_stats (id_stats, id_game, id_player, Two_points_made, Two_points_try, Three_points_made, Three_points_try, Free_points_made, Free_points_try, Rebounds_off, Rebounds_def, Steals, Blocks, Loss, Fouls)" +
                                        "VALUES('"+idstatscount+"','"+idgame+"','" +idplayer.get(i)+"','"+twopointsin[0]+"','"+twopointstry[0]+"','"+threepointstry[0]+"','"+threepointstry[0]+"','0','0','"+rebdeff[0]+"','"+rebdeff[0]+"','"+steal[0]+"','0','"+loss[0]+"','0')");
                                statement4.executeUpdate("UPDATE Games SET game_state = '0' WHERE id_game = '"+idgame+"'");
                                String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                                statement4.executeUpdate("UPDATE Games SET game_date ='"+currentDate+"' WHERE id_game ='"+idgame+"'");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                endtracking.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(getApplicationContext(), GamesEndedActivity.class);
                        startActivity(in);
                    }
                });
            }
        });
    }
}

