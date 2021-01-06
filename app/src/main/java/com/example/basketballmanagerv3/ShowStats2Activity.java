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

public class ShowStats2Activity extends AppCompatActivity {


    ListView StatsListView;
    ListView StatsListView2;

    TextView sum1;
    TextView sum2;
    TextView sum3;
    TextView rebot;
    TextView rebat;
    TextView stealt;
    TextView blockt;
    TextView turnt;
    TextView foult;
    TextView pktt;
    TextView evalt;

    TextView sum12;
    TextView sum22;
    TextView sum32;
    TextView rebot2;
    TextView rebat2;
    TextView stealt2;
    TextView blockt2;
    TextView turnt2;
    TextView foult2;
    TextView pktt2;
    TextView evalt2;



    private ArrayList<HashMap<String, String>> list2;
    private ArrayList<HashMap<String, String>> list3;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_game_stats);
        this.setTitle("Players Stats");
        StatsListView = findViewById(R.id.listViewStats);
        StatsListView2= findViewById(R.id.listViewStats2);

        sum1 = findViewById(R.id.twoptssum);
        sum2 = findViewById(R.id.threeptssum);
        sum3 = findViewById(R.id.oneptssum);
        rebot = findViewById(R.id.rebosum);
        rebat = findViewById(R.id.rebasum);
        stealt = findViewById(R.id.stealsum);
        blockt = findViewById(R.id.blocksum);
        turnt = findViewById(R.id.turnsum);
        foult = findViewById(R.id.foulssum);
        pktt = findViewById(R.id.pktsum);
        evalt = findViewById(R.id.evalsum);

        sum12 = findViewById(R.id.twoptssum2);
        sum22 = findViewById(R.id.threeptssum2);
        sum32 = findViewById(R.id.oneptssum2);
        rebot2 = findViewById(R.id.rebosum2);
        rebat2 = findViewById(R.id.rebasum2);
        stealt2 = findViewById(R.id.stealsum2);
        blockt2 = findViewById(R.id.blocksum2);
        turnt2 = findViewById(R.id.turnsum2);
        foult2 = findViewById(R.id.foulssum2);
        pktt2 = findViewById(R.id.pktsum2);
        evalt2 = findViewById(R.id.evalsum2);


        list2 = new ArrayList<>();
        list3 = new ArrayList<>();


        Intent in = getIntent();
        final String teamname1 = in.getStringExtra("team1");
        final String teamname2 = in.getStringExtra("team2");
        final String data = in.getStringExtra("data");

        TextView team = findViewById(R.id.team_name);
        team.setText("              " + teamname1);

        TextView player = findViewById(R.id.team_name2);
        player.setText("              " + teamname2);

        TextView dataa = findViewById(R.id.data);
        dataa.setText(data);



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

        int sumtwopoints = 0;
        int sumthreepoints = 0;
        int sumonepoints = 0;
        int sumrebo = 0;
        int sumreba = 0;
        int sumsteal = 0;
        int sumblock = 0;
        int sumturn = 0;
        int sumfouls = 0;
        int sumpkt = 0;
        int sumeval = 0;

        int sumtwopoints2 = 0;
        int sumthreepoints2 = 0;
        int sumonepoints2 = 0;
        int sumrebo2 = 0;
        int sumreba2 = 0;
        int sumsteal2 = 0;
        int sumblock2 = 0;
        int sumturn2 = 0;
        int sumfouls2 = 0;
        int sumpkt2 = 0;
        int sumeval2 = 0;

        int pkt;
        int eval;

        String playername = null;

        if(conect.CONN() != null){
            Statement statement = null;
            Statement statement2 = null;
            try {
                statement = conect.CONN().createStatement();
                statement2 = conect.CONN().createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE T_idteam.teamname ='"+teamname1+"'");
                while(result.next()) {
                    playername = result.getString("player_name");
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

                    sumtwopoints += twoptsmade *2;
                    sumthreepoints += threeptsmade*3;
                    sumonepoints += freeptsmade;
                    sumrebo += rebo;
                    sumreba += reba;
                    sumsteal += steal;
                    sumblock += block;
                    sumturn += turn;
                    sumfouls += fouls;


                    pkt = twoptsmade*2 + threeptsmade*3 + freeptsmade;
                    eval = twoptsmade + threeptsmade + freeptsmade + block + turn + reba + rebo + steal - (twoptstry+threeptstry+freeptstry+fouls);

                    sumpkt += pkt;
                    sumeval += eval;

                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(FIRST_COLUMN, playername);
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
                    final ListViewAdapterStats adapter = new ListViewAdapterStats(ShowStats2Activity.this, list2);
                    StatsListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                sum1.setText(sumtwopoints+"");
                sum2.setText(sumthreepoints+"");
                sum3.setText(sumonepoints+"");
                rebot.setText(sumrebo+"");
                rebat.setText(sumreba+"");
                stealt.setText(sumsteal+"");
                blockt.setText(sumblock+"");
                turnt.setText(sumturn+"");
                foult.setText(sumfouls+"");
                pktt.setText(sumpkt+"");
                evalt.setText(sumeval+"");

                ResultSet result2 = statement2.executeQuery("SELECT * FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE T_idteam.teamname ='"+teamname2+"'");
                while(result2.next()) {
                    playername = result2.getString("player_name");
                    twoptsmade = result2.getInt("Two_points_made");
                    twoptstry = result2.getInt("Two_points_try");
                    threeptsmade = result2.getInt("Three_points_made");
                    threeptstry = result2.getInt("Three_points_try");
                    freeptsmade = result2.getInt("Free_points_made");
                    freeptstry = result2.getInt("Free_points_try");
                    rebo = result2.getInt("Rebounds_off");
                    reba = result2.getInt("Rebounds_def");
                    steal = result2.getInt("Steals");
                    block = result2.getInt("Blocks");
                    turn = result2.getInt("Loss");
                    fouls = result2.getInt("Fouls");

                    int two = twoptsmade+twoptstry;
                    int three = threeptsmade+threeptstry;
                    int one = freeptsmade+freeptstry;

                    sumtwopoints2 += twoptsmade *2;
                    sumthreepoints2 += threeptsmade*3;
                    sumonepoints2 += freeptsmade;
                    sumrebo2 += rebo;
                    sumreba2 += reba;
                    sumsteal2 += steal;
                    sumblock2 += block;
                    sumturn2 += turn;
                    sumfouls2 += fouls;

                    pkt = twoptsmade*2 + threeptsmade*3 + freeptsmade;
                    eval = twoptsmade + threeptsmade + freeptsmade + block + reba + rebo + steal - (twoptstry+threeptstry+freeptstry+fouls+turn);

                    sumpkt2 += pkt;
                    sumeval2 += eval;

                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(FIRST_COLUMN, playername);
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

                    list3.add(temp);
                    final ListViewAdapterStats adapter = new ListViewAdapterStats(ShowStats2Activity.this, list3);
                    StatsListView2.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                sum12.setText(sumtwopoints2+"");
                sum22.setText(sumthreepoints2+"");
                sum32.setText(sumonepoints2+"");
                rebot2.setText(sumrebo2+"");
                rebat2.setText(sumreba2+"");
                stealt2.setText(sumsteal2+"");
                blockt2.setText(sumblock2+"");
                turnt2.setText(sumturn2+"");
                foult2.setText(sumfouls2+"");
                pktt2.setText(sumpkt2+"");
                evalt2.setText(sumeval2+"");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
