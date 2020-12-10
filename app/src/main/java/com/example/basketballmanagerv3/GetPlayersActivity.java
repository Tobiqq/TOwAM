package com.example.basketballmanagerv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballmanagerv3.Helpers.ListViewAdapter;
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

public class GetPlayersActivity extends AppCompatActivity {


    ListView PlayerListView;
    private ArrayList<HashMap<String, String>> list2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_players_activity);
        this.setTitle("Players");

        PlayerListView = findViewById(R.id.listView3);
        list2 = new ArrayList<>();


        Intent in = getIntent();
        String teamname = in.getStringExtra("team");
        final String position = getIntent().getExtras().getString("position");
        final String Id = in.getStringExtra("id");
        TextView team = findViewById(R.id.team_name);
        team.setText("              " + teamname);


        Button btn = findViewById(R.id.addPlayer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(GetPlayersActivity.this, AddPlayerActivity.class);
                in.putExtra("position", position);
                in.putExtra("id", Id);
                startActivity(in);
            }
        });

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("teams/"+ Id +"/players");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String name = snapshot.child("playername").getValue(String.class);
                    int number = snapshot.child("playerNumber").getValue(int.class);
                    String position = snapshot.child("position").getValue(String.class);
                    HashMap<String, String> temp = new HashMap<String, String>();
                    temp.put(FIRST_COLUMN, name);
                    temp.put(SECOND_COLUMN, Integer.toString(number));
                    temp.put(THIRD_COLUMN, position);
                    list2.add(temp);
                    final ListViewAdapter adapter = new ListViewAdapter(GetPlayersActivity.this, list2);
                    PlayerListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
