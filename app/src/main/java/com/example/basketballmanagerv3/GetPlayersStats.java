package com.example.basketballmanagerv3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.ListViewAdapterStats;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.EIGHTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.ELEVENTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.FIFTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.FOURTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.NINETH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SEVENTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SIXTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.TENTH_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.THIRD_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.TWELWETH_COLUMN;

public class GetPlayersStats extends AppCompatActivity {


    ListView StatsListView;
    private ArrayList<HashMap<String, String>> list2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_players_stats);
        this.setTitle("Players Stats");
        StatsListView = findViewById(R.id.listViewStats);
        list2 = new ArrayList<>();


        Intent in = getIntent();
        final String teamname = in.getStringExtra("team");
        final String name = in.getStringExtra("name");

        TextView team = findViewById(R.id.team_name);
        team.setText("              " + teamname);

        TextView player = findViewById(R.id.player_name);
        player.setText("              " + name);



        final ConnectionsClass conect = new ConnectionsClass();
        int twoptsmade;
        int twoptstry;
        int threeptsmade;
        int threeptstry;
        int freeptsmade;
        int freeptstry;
        int rebo;
        int reba;
        int steal;
        int block;
        int turn;
        int fouls;

        int pkt;
        int eval;

        int vs = 0;
        int vstwo = 0;
        int vscomp = 0;
        String vsendx = null;

        if(conect.CONN() != null){
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
                ResultSet result2 = statement5.executeQuery("SELECT id_team_home, id_team_guest FROM Games WHERE id_game = (SELECT id_game FROM Match_stats WHERE id_player = (SELECT id_player FROM Players WHERE player_name = '"+name+"'))");
                while(result2.next()) {
                    vs = result2.getInt("id_team_home");
                    vstwo = result2.getInt("id_team_guest");
                }
                ResultSet result3 = statement2.executeQuery("SELECT id_team FROM Teams WHERE teamname = '"+teamname+"'");
                while(result3.next()) {
                    vscomp = result3.getInt("id_team");
                }
                if(vs == vscomp)
                {
                    ResultSet result4 = statement3.executeQuery("SELECT teamname FROM Teams WHERE id_team = '"+vstwo+"'");
                    while(result4.next()) {
                        vsendx = result4.getString("teamname");
                    }
                }else {
                    ResultSet result5 = statement4.executeQuery("SELECT teamname FROM Teams WHERE id_team = '"+vs+"'");
                    while(result5.next()) {
                        vsendx = result5.getString("teamname");
                    }
                }

                ResultSet result = statement.executeQuery("SELECT * FROM Match_stats WHERE id_player = (SELECT id_player FROM Players WHERE player_name = '"+name+"')");
                while(result.next()){
                    twoptsmade = result.getInt("Two_points_made");
                    twoptstry = result.getInt("Two_points_try");
                    threeptsmade = result.getInt("Three_points_made");
                    threeptstry = result.getInt("Three_points_try");
                    freeptsmade = result.getInt("Free_points_made");
                    freeptstry = result.getInt("Free_points_try");
                    rebo = result.getInt("Rebounds_off");
                    reba = result.getInt("Rebounds_def");
                    steal = result.getInt("Steals");
                    block = result.getInt("Blocks");
                    turn = result.getInt("Loss");
                    fouls = result.getInt("Fouls");

                    int two = twoptsmade+twoptstry;
                    int three = threeptsmade+threeptstry;
                    int one = freeptsmade+freeptstry;

                    pkt = twoptsmade*2 + threeptsmade*3 + freeptsmade;
                    eval = twoptsmade + threeptsmade + freeptsmade + block + reba + rebo + steal - (twoptstry+threeptstry+freeptstry+fouls+turn);

                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(FIRST_COLUMN, vsendx);
                    temp.put(SECOND_COLUMN, twoptsmade + "/" + two);
                    temp.put(THIRD_COLUMN, threeptsmade + "/" + three);
                    temp.put(FOURTH_COLUMN, freeptsmade + "/" + one);
                    temp.put(FIFTH_COLUMN, rebo + "");
                    temp.put(SIXTH_COLUMN, reba + "");
                    temp.put(SEVENTH_COLUMN, steal + "");
                    temp.put(EIGHTH_COLUMN, block + "");
                    temp.put(NINETH_COLUMN, turn + "");
                    temp.put(TENTH_COLUMN, fouls + "");
                    temp.put(ELEVENTH_COLUMN, pkt + "");
                    temp.put(TWELWETH_COLUMN, eval + "");

                    list2.add(temp);
                    final ListViewAdapterStats adapter = new ListViewAdapterStats(GetPlayersStats.this, list2);
                    StatsListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
