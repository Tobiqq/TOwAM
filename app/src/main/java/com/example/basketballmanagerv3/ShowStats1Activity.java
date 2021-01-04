package com.example.basketballmanagerv3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.ListViewAdapterButton3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;

public class ShowStats1Activity extends AppCompatActivity {

    ListView StatsListView;
    private ArrayList<HashMap<String, String>> list2;
    int temp;
    int temp2guest;
    int temp2home;
    int temp3guest;
    int temp3home;
    int temp1guest;
    int temp1home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_stats_1);
        this.setTitle("Stats");
        StatsListView = findViewById(R.id.listViewStats);
        list2 = new ArrayList<HashMap<String, String>>();

        Intent in = getIntent();
        final String teamname = in.getStringExtra("team");

        TextView team = findViewById(R.id.team_name);
        team.setText("              " + teamname);

        int twoptsmade;
        int twoptstry;
        int threeptsmade;
        int threeptstry;
        int freeptsmade;
        int freeptstry;
        int pkt;

        int vs = 0;
        int vstwo = 0;
        int vscomp = 0;
        String vsendx = null;

        final ConnectionsClass conect = new ConnectionsClass();


        if(conect.CONN() != null){
            Statement statement = null;
            Statement statement2 = null;
            Statement statement3 = null;
            Statement statement4 = null;
            Statement statement5 = null;
            Statement statement6 = null;
            Statement statement7 = null;
            Statement statement8 = null;
            Statement statement9 = null;
            Statement statement10 = null;
            Statement statement11 = null;
            try {
                statement = conect.CONN().createStatement();
                statement2 = conect.CONN().createStatement();
                statement3 = conect.CONN().createStatement();
                statement4 = conect.CONN().createStatement();
                statement5 = conect.CONN().createStatement();
                statement6 = conect.CONN().createStatement();
                statement7 = conect.CONN().createStatement();
                statement8 = conect.CONN().createStatement();
                statement9 = conect.CONN().createStatement();
                statement10 = conect.CONN().createStatement();
                statement11 = conect.CONN().createStatement();

                ResultSet result = statement.executeQuery("SELECT id_game AS Total_id FROM Games WHERE game_state = '0' AND id_team_home = (SELECT id_team FROM Teams WHERE teamname = '"+teamname+"') OR game_state = '0' AND id_team_guest = (SELECT id_team FROM Teams WHERE teamname = '"+teamname+"')");
                while(result.next()){
                    temp = result.getInt("Total_id");

                    ResultSet result3 = statement3.executeQuery("SELECT id_team_home, id_team_guest FROM Games WHERE id_game ='"+temp+"'");
                    while(result3.next()) {
                        vs = result3.getInt("id_team_home");
                        vstwo = result3.getInt("id_team_guest");
                    }
                    ResultSet result4 = statement4.executeQuery("SELECT id_team FROM Teams WHERE teamname = '"+teamname+"'");
                    while(result4.next()) {
                        vscomp = result4.getInt("id_team");
                    }
                    if(vs == vscomp)
                    {
                        ResultSet result5 = statement5.executeQuery("SELECT teamname FROM Teams WHERE id_team = '"+vstwo+"'");
                        while(result5.next()) {
                            vsendx = result5.getString("teamname");

                            ResultSet result2 = statement2.executeQuery("SELECT SUM (Two_points_made) AS Total2 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vstwo+"'");
                            while(result2.next()){
                                temp2guest = (result2.getInt("Total2"));

                                ResultSet result7 = statement7.executeQuery("SELECT SUM (Two_points_made) AS Total2 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vs+"'");
                                while(result7.next()){
                                    temp2home = (result7.getInt("Total2"));

                                    ResultSet result8 = statement8.executeQuery("SELECT SUM (Three_points_made) AS Total3 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vstwo+"'");
                                    while(result8.next()){
                                        temp3guest = (result8.getInt("Total3"));

                                        ResultSet result9 = statement9.executeQuery("SELECT SUM (Three_points_made) AS Total3 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vs+"'");
                                        while(result9.next()){
                                            temp3home = (result9.getInt("Total3"));

                                            ResultSet result10 = statement10.executeQuery("SELECT SUM (Free_points_made) AS Total1 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vstwo+"'");
                                            while(result10.next()){
                                                temp1guest = (result10.getInt("Total1"));

                                                ResultSet result11 = statement11.executeQuery("SELECT SUM (Free_points_made) AS Total1 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vs+"'");
                                                while(result11.next()){
                                                    temp1home = (result11.getInt("Total1"));

                                                    int wynikhome = temp1home + temp2home *2 + temp3home *3;
                                                    int wynikguest = temp1guest + temp2guest *2 + temp3guest *3;
                                                    HashMap<String, String> temp = new HashMap<>();
                                                    temp.put(SECOND_COLUMN, vsendx);
                                                    temp.put(FIRST_COLUMN, wynikhome + " : "+ wynikguest);
                                                    list2.add(temp);
                                                    final ListViewAdapterButton3 adapter = new ListViewAdapterButton3(ShowStats1Activity.this, list2, teamname);
                                                    StatsListView.setAdapter(adapter);
                                                    adapter.notifyDataSetChanged();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        ResultSet result6 = statement6.executeQuery("SELECT teamname FROM Teams WHERE id_team = '" + vs + "'");
                        while (result6.next()) {
                            vsendx = result6.getString("teamname");

                            ResultSet result2 = statement2.executeQuery("SELECT SUM (Two_points_made) AS Total2 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vs+"'");
                            while(result2.next()){
                                temp2guest = (result2.getInt("Total2"));

                                ResultSet result7 = statement7.executeQuery("SELECT SUM (Two_points_made) AS Total2 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vstwo+"'");
                                while(result7.next()){
                                    temp2home = (result7.getInt("Total2"));

                                    ResultSet result8 = statement8.executeQuery("SELECT SUM (Three_points_made) AS Total3 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vs+"'");
                                    while(result8.next()){
                                        temp3guest = (result8.getInt("Total3"));

                                        ResultSet result9 = statement9.executeQuery("SELECT SUM (Three_points_made) AS Total3 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vstwo+"'");
                                        while(result9.next()){
                                            temp3home = (result9.getInt("Total3"));

                                            ResultSet result10 = statement10.executeQuery("SELECT SUM (Free_points_made) AS Total1 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vs+"'");
                                            while(result10.next()){
                                                temp1guest = (result10.getInt("Total1"));

                                                ResultSet result11 = statement11.executeQuery("SELECT SUM (Free_points_made) AS Total1 FROM Players LEFT JOIN Teams T_idteam on T_idteam.id_team = Players.id_team LEFT JOIN Match_stats M_idplayer on M_idplayer.id_player = Players.id_player WHERE Players.id_team = '"+vstwo+"'");
                                                while(result11.next()){
                                                    temp1home = (result11.getInt("Total1"));

                                                    int wynikhome = temp1home + temp2home *2 + temp3home *3;
                                                    int wynikguest = temp1guest + temp2guest *2 + temp3guest *3;
                                                    HashMap<String, String> temp = new HashMap<>();
                                                    temp.put(SECOND_COLUMN, vsendx);
                                                    temp.put(FIRST_COLUMN, wynikhome + " : "+ wynikguest);
                                                    list2.add(temp);
                                                    final ListViewAdapterButton3 adapter = new ListViewAdapterButton3(ShowStats1Activity.this, list2, teamname);
                                                    StatsListView.setAdapter(adapter);
                                                    adapter.notifyDataSetChanged();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}












