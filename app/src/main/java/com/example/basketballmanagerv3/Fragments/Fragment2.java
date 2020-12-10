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
import com.example.basketballmanagerv3.Helpers.ListViewAdapterButton;
import com.example.basketballmanagerv3.R;
import com.example.basketballmanagerv3.SixthActivity;
import com.example.basketballmanagerv3.TrackGameActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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


        GameListView = view.findViewById(R.id.listView2);
        list = new ArrayList<>();

        final ListViewAdapterButton adapter = new ListViewAdapterButton(getActivity(), list);
        GameListView.setAdapter(adapter);

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


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("games");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String team1 = snapshot.child("hostName").getValue(String.class);
                    String team2 = snapshot.child("guestName").getValue(String.class);
                    HashMap<String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, team1);
                    temp.put(SECOND_COLUMN, team2);
                    list.add(temp);
                    final ListViewAdapterButton adapter = new ListViewAdapterButton(getActivity(), list);
                    GameListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
