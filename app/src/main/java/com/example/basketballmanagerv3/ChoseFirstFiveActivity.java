package com.example.basketballmanagerv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.example.basketballmanagerv3.Helpers.RecyclerAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class ChoseFirstFiveActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerAdapter recyclerAdapter;
    RecyclerAdapter recyclerAdapter2;

    private ArrayList<String> listplayer1;
    private ArrayList<String> listplayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_first_five);

        Intent in = getIntent();
        final String teamname1 = in.getStringExtra("team1");
        final String teamname2 = in.getStringExtra("team2");
        final Integer position = getIntent().getExtras().getInt("position");


        listplayer1 = new ArrayList<>();
        listplayer2 = new ArrayList<>();

        TextView team1 = findViewById(R.id.home);
        TextView team2 = findViewById(R.id.guest);
        team1.setText(teamname1);
        team2.setText(teamname2);



        final ConnectionsClass conect = new ConnectionsClass();
        if(conect.CONN() != null){
            Statement statement = null;
            Statement statement2 = null;
            try {
                statement = conect.CONN().createStatement();
                statement2 = conect.CONN().createStatement();
                ResultSet result = statement.executeQuery("SELECT player_name FROM Players WHERE id_team = (SELECT id_team FROM Teams WHERE teamname = '"+teamname1+"')");
                while (result.next()) {
                    String temp = result.getString(1);
                    listplayer1.add(temp);
                }
                ResultSet result2 = statement2.executeQuery("SELECT player_name FROM Players WHERE id_team = (SELECT id_team FROM Teams WHERE teamname = '"+teamname2+"')");
                while (result2.next()) {
                    String temp2 = result2.getString(1);
                    listplayer2.add(temp2);
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        recyclerAdapter = new RecyclerAdapter(listplayer1);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        recyclerAdapter2 = new RecyclerAdapter(listplayer2);
        final ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(simpleCallback);
        final DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addItemDecoration(dividerItemDecoration);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView2.setAdapter(recyclerAdapter2);
        recyclerView2.addItemDecoration(dividerItemDecoration2);
        itemTouchHelper2.attachToRecyclerView(recyclerView2);



        Button btn = findViewById(R.id.trackGame2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Track your game!", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(), TrackGameActivity.class);
                in.putExtra("team1", teamname1);
                in.putExtra("team2", teamname2);
                in.putExtra("position", position);
                in.putExtra("team1players", listplayer1);
                in.putExtra("team2players", listplayer2);
                startActivity(in);
            }
        });
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            Collections.swap(listplayer1, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}












