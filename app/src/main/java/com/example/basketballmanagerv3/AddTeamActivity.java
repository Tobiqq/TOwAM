package com.example.basketballmanagerv3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.basketballmanagerv3.Helpers.ConnectionsClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class AddTeamActivity extends AppCompatActivity {

    private Spinner spinner;
    EditText teamname, teamshortcut, teamleague;
    Button Savebutton, Cancelbutton;
    FirebaseDatabase database;
    DatabaseReference refernce;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams_popup);
        this.setTitle("Add Team");

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);


        spinner = findViewById(R.id.teamleague);
        String[] value = {"--Choose Your League--","1 Liga Mężczyzn","2 Liga Mężczyzn","3 Liga Mężczyzn","Rozgrywki Amatorskie"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, arrayList){
            @SuppressLint("ResourceAsColor")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green3));
                }
                else {
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green));
                }
                return view;
            }
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @SuppressLint("ResourceAsColor")
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green3));
                }
                else {
                    tv.setTextColor(getApplicationContext().getResources().getColor(R.color.green));
                }
                return view;
            }
        };
        arrayAdapter.setDropDownViewResource(R.layout.style_spinner);
        spinner.setAdapter(arrayAdapter);

        teamname = findViewById(R.id.teamname);
        teamshortcut = findViewById(R.id.teamshortcut);

        Savebutton = findViewById(R.id.Savebutton);
        Cancelbutton = findViewById(R.id.Cancelbutton);


        final ConnectionsClass conect = new ConnectionsClass();


        Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team = teamname.getText().toString();
                String tag = teamshortcut.getText().toString();
                String league = spinner.getSelectedItem().toString();
/*                database = FirebaseDatabase.getInstance();
                refernce = database.getReference("teams");
                CollectHelperClass collect = new CollectHelperClass(team,tag,league);
                refernce.push().setValue(collect);*/
                if(conect.CONN() != null){
                    Statement statement = null;
                    try {
                        statement = conect.CONN().createStatement();
                        ResultSet idteam = statement.executeQuery("SELECT COUNT (id_team) AS total FROM Teams");
                        int idteamcount = 0;
                        while(idteam.next()){
                            idteamcount = idteam.getInt("total");
                            idteamcount += 1;
                        }
                        ResultSet result = statement.executeQuery("INSERT INTO Teams (id_team, teamname, tag, league) VALUES"+"('" +idteamcount+ "'," + "'" +team+ "'," + "'" +tag+"'," + "'"+league+"')");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

                Context context = getApplicationContext();
                Toast.makeText(context, "Data added succesfully!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}


