package com.example.basketballmanagerv3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.ListViewAdapterButton2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;


public class GamesEndedActivity extends AppCompatActivity {


    ListView GameListView2;
    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamesended);
        Activity activity;
        this.setTitle("Ended Games");
        GameListView2 = findViewById(R.id.listView3);
        list = new ArrayList<>();
        final ListViewAdapterButton2 adapter = new ListViewAdapterButton2(this, list);
        GameListView2.setAdapter(adapter);
        ArrayList<String> IdListGames = new ArrayList<>();



        final ConnectionsClass conect = new ConnectionsClass();
        int team1 = 0;
        int team2 = 0;
        String team1str = null;
        String team2str = null;
        if(conect.CONN() != null){
            Statement statement = null;
            Statement statement2 = null;
            Statement statement3 = null;
            try {
                statement = conect.CONN().createStatement();
                statement2 = conect.CONN().createStatement();
                statement3 = conect.CONN().createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM Games WHERE game_state = '0'");
                while (result.next()) {
                    IdListGames.add(result.getString("id_game"));
                    team1 = result.getInt("id_team_home");
                    team2 = result.getInt("id_team_guest");
                    ResultSet result2 = statement2.executeQuery("SELECT teamname FROM Teams WHERE id_team='"+team1+"'");
                    while (result2.next()) {
                        team1str = result2.getString(1);
                    }
                    ResultSet result3 = statement3.executeQuery("SELECT teamname FROM Teams WHERE id_team='"+team2+"'");
                    while (result3.next()) {
                        team2str = result3.getString(1);
                    }
                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(FIRST_COLUMN, team1str);
                    temp.put(SECOND_COLUMN, team2str);
                    list.add(temp);
                    final ListViewAdapterButton2 adapter2 = new ListViewAdapterButton2(this, list);
                    GameListView2.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}


