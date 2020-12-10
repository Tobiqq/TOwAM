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

import com.example.basketballmanagerv3.AddTeamActivity;
import com.example.basketballmanagerv3.GetPlayersActivity;
import com.example.basketballmanagerv3.Helpers.ListViewAdapter;
import com.example.basketballmanagerv3.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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


        TeamListView = view.findViewById(R.id.teamListView);
        list = new ArrayList<>();

        final ListViewAdapter adapter = new ListViewAdapter(getActivity(), list);
        TeamListView.setAdapter(adapter);


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


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("teams");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    IdList.add(snapshot.getKey());
                    String team = snapshot.child("teamname").getValue(String.class);
                    String tag = snapshot.child("teamtag").getValue(String.class);
                    String league = snapshot.child("league").getValue(String.class);
                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(FIRST_COLUMN, team);
                    temp.put(SECOND_COLUMN, tag);
                    temp.put(THIRD_COLUMN, league);
                    list.add(temp);
                    final ListViewAdapter adapter = new ListViewAdapter(getActivity(), list);
                    TeamListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
