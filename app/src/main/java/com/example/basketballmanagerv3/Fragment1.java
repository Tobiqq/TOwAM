package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.basketballmanagerv3.Constants.FIRST_COLUMN;
import static com.example.basketballmanagerv3.Constants.SECOND_COLUMN;
import static com.example.basketballmanagerv3.Constants.THIRD_COLUMN;


public class Fragment1 extends Fragment {
    private static final String TAG = "Fragment1";
    private Activity activity;
    ListView TeamListView;

    private ArrayList<HashMap<String, String>> list;
    public String Id;
    ArrayList<String> IdList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment1_team_manager, container, false);
        getActivity().setTitle("Added Teams");


        TeamListView = (ListView) view.findViewById(R.id.listView1);
        list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> temp = new HashMap<String, String>();

        final ListViewAdapter adapter = new ListViewAdapter(getActivity(), list);
        TeamListView.setAdapter(adapter);


        TeamListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), i + "position clicked", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getActivity(), FourtActivity.class);
                in.putExtra("team", list.get(i).get(FIRST_COLUMN).toString());
                in.putExtra("position", i);
                in.putExtra("id", IdList.get(i).toString());
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
                    HashMap<String, String> temp = new HashMap<String, String>();
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


        /*final ArrayList<String> TeamList = new ArrayList<>();
        final ArrayAdapter myArrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.team_list_item, TeamList);
        TeamListView.setAdapter(myArrayAdapter);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("teams");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TeamList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    String team = snapshot.child("teamname").getValue(String.class);
                    String tag = snapshot.child("teamtag").getValue(String.class);
                    String league = snapshot.child("league").getValue(String.class);
                    TeamList.add(team + "-" + tag + "-" + league);
                    myArrayAdapter.notifyDataSetChanged();
                }
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    TeamList.add(snapshot.getValue().toString());
                }
                myArrayAdapter.notifyDataSetChanged();
                String team = dataSnapshot.child("teamname").getValue(String.class);
                String tag = dataSnapshot.child("teamtag").getValue(String.class);
                String league = dataSnapshot.child("league").getValue(String.class);
                String txt = team + "-" + tag + "-" + league;
                TeamList.add(txt);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        Button btn = (Button) view.findViewById(R.id.addTeam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), SecondActivity.class);
                startActivity(in);
            }
        });
        return view;
    }
}
