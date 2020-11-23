package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

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


public class Fragment2 extends Fragment {
    private static final String TAG = "Fragment2";
    private Activity activity;
    ListView GameListView;

    private ArrayList<HashMap<String, String>> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_game_manager, container, false);
        getActivity().setTitle("Added Games");


        GameListView = (ListView)view.findViewById(R.id.listView2);
        list = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> temp = new HashMap<String, String>();

        final ListViewAdapterButton adapter = new ListViewAdapterButton(getActivity(), list);
        GameListView.setAdapter(adapter);

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

        Button btn = (Button) view.findViewById(R.id.addGame);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), ThirdActivity.class);
                startActivity(in);
            }
        });
        return view;
    }
}
