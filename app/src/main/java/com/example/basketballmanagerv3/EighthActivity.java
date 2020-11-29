package com.example.basketballmanagerv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EighthActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerAdapter recyclerAdapter;
    RecyclerAdapter recyclerAdapter2;

    List<String> moviesList;

    FirebaseDatabase database;
    Activity activity;
    private ArrayList<String> listplayer1;
    private ArrayList<String> listplayer2;
    String[] tab;
    String team1key;
    String team2key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigth);

        Intent in = getIntent();
        String teamname1 = in.getStringExtra("team1");
        String teamname2 = in.getStringExtra("team2");
        Integer position = getIntent().getExtras().getInt("position");
        listplayer1 = new ArrayList<String>();
        listplayer2 = new ArrayList<String>();


        Query reference = FirebaseDatabase.getInstance().getReference("teams").orderByChild("teamname").equalTo(teamname1);
        recyclerAdapter = new RecyclerAdapter(listplayer1);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        reference.addListenerForSingleValueEvent(new ValueEventListener(){
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    team1key = childSnapshot.getKey();
                    Log.i("err", team1key);
                }
                Query reference2 = FirebaseDatabase.getInstance().getReference("teams").child(team1key).child("players");
                reference2.addValueEventListener(new ValueEventListener() {
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String playern = snapshot.child("playername").getValue(String.class);
                            listplayer1.add(playern);
                            Log.i("errplay", playern);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                            recyclerView.setAdapter(recyclerAdapter);
                            recyclerView.addItemDecoration(dividerItemDecoration);
                            itemTouchHelper.attachToRecyclerView(recyclerView);
                        }
                    }

                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        Query reference3 = FirebaseDatabase.getInstance().getReference("teams").orderByChild("teamname").equalTo(teamname2);
        recyclerAdapter2 = new RecyclerAdapter(listplayer2);
        final ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(simpleCallback);
        final DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);



        reference3.addListenerForSingleValueEvent(new ValueEventListener(){
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    team2key = childSnapshot.getKey();
                    Log.i("err", team2key);
                }
                Query reference4 = FirebaseDatabase.getInstance().getReference("teams").child(team2key).child("players");
                reference4.addValueEventListener(new ValueEventListener() {
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String playern = snapshot.child("playername").getValue(String.class);
                            listplayer2.add(playern);
                            Log.i("errplay", playern);


//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                            recyclerView2.setAdapter(recyclerAdapter2);
                            recyclerView2.addItemDecoration(dividerItemDecoration2);
                            itemTouchHelper2.attachToRecyclerView(recyclerView2);

                        }
                    }

                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            Collections.swap(listplayer1, fromPosition, toPosition);
            Collections.swap(listplayer2, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

}












