package com.example.basketballmanagerv3.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.basketballmanagerv3.AddTeamActivity;
import com.example.basketballmanagerv3.GetPlayersActivity;
import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.ListViewAdapter;
import com.example.basketballmanagerv3.R;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Helpers.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.SECOND_COLUMN;
import static com.example.basketballmanagerv3.Helpers.Constants.THIRD_COLUMN;

public class Fragment1 extends Fragment {

    ListView TeamListView;
    private ArrayList<HashMap<String, String>> list;
    ArrayList<String> IdList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment1_team_manager, container, false);
        getActivity().setTitle("Added Teams");


        Fragment1.this.onResume();

        TeamListView = view.findViewById(R.id.teamListView);
        list = new ArrayList<>();
        final ListViewAdapter adapter = new ListViewAdapter(getActivity(), list);
        TeamListView.setAdapter(adapter);


        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        final ConnectionsClass conect = new ConnectionsClass();
        String team;
        String tag;
        String league;
        if(conect.CONN() != null){
            Statement statement = null;
            try {
                statement = conect.CONN().createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM Teams");
                while(result.next()){
                    IdList.add(result.getString("id_team"));
                    team = result.getString("teamname");
                    tag = result.getString("tag");
                    league = result.getString("league");
                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(FIRST_COLUMN, team);
                    temp.put(SECOND_COLUMN, tag);
                    temp.put(THIRD_COLUMN, league);
                    list.add(temp);
                    final ListViewAdapter adapter2 = new ListViewAdapter(getActivity(), list);
                    TeamListView.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        TeamListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(), GetPlayersActivity.class);
                in.putExtra("team", list.get(i).get(FIRST_COLUMN));
                in.putExtra("position", i);
                in.putExtra("id", IdList.get(i));
                startActivity(in);
            }
        });



        Button btn = view.findViewById(R.id.addTeam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), AddTeamActivity.class);
                startActivity(in);
            }
        });
        return view;
    }

}
