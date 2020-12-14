package com.example.basketballmanagerv3.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.basketballmanagerv3.AddGameActivity;
import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.ListViewAdapterButton;
import com.example.basketballmanagerv3.R;
import com.example.basketballmanagerv3.SixthActivity;
import com.example.basketballmanagerv3.TrackGameActivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;


public class Fragment2 extends Fragment {

    ListView GameListView;
    private ArrayList<HashMap<String, String>> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_game_manager, container, false);
        getActivity().setTitle("Added Games");

        ArrayList<String> IdListGames = new ArrayList<>();
        GameListView = view.findViewById(R.id.listView2);
        list = new ArrayList<>();

        final ListViewAdapterButton adapter = new ListViewAdapterButton(getActivity(), list);
        GameListView.setAdapter(adapter);


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
                ResultSet result = statement.executeQuery("SELECT * FROM Games");
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
                    final ListViewAdapterButton adapter2 = new ListViewAdapterButton(getActivity(), list);
                    GameListView.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        GameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(), TrackGameActivity.class);
                in.putExtra("team1", list.get(i).get(FIRST_COLUMN));
                in.putExtra("team2", list.get(i).get(SECOND_COLUMN));
                in.putExtra("position", i);
                startActivity(in);
            }
        });


        Button addGameButton= view.findViewById(R.id.addGame);
        Button gamesEndedButton = view.findViewById(R.id.gamesended);

        addGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), AddGameActivity.class);
                startActivity(in);
            }
        });

        gamesEndedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secin = new Intent(getActivity(), SixthActivity.class);
                startActivity(secin);
            }
        });
        return view;
    }
}
