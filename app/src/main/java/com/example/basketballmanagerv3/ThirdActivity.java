package com.example.basketballmanagerv3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class  ThirdActivity extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner2;
    Button Savebutton, Cancelbutton;
    FirebaseDatabase database;
    DatabaseReference refernce;
    EditText hostname, guestname;

    private ArrayList<HashMap<String, String>> list;
    Activity activity;
    ListView TeamListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamespopup);
        Activity activity;
        this.setTitle("Add Game");

        Savebutton = findViewById(R.id.Savebutton2);
        Cancelbutton = findViewById(R.id.Cancelbutton2);

        spinner = findViewById(R.id.hostteamname);
        spinner2 = findViewById(R.id.guestteamname);


        final ArrayList<String> list = new ArrayList<>();
        list.add("--Choose Team--");
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.team_list_item2, list);
        DatabaseReference referance = FirebaseDatabase.getInstance().getReference().child("teams");
        referance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    list.add(snapshot.child("teamname").getValue(String.class));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        String[] value = {"Tutaj lista teamów z bazy"};
        String[] value2 = {"Druga lista teamó z bazy"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(value));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, list){
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
        final ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.style_spinner,R.id.tvLeague2, list){
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
        arrayAdapter2.setDropDownViewResource(R.layout.style_spinner);
        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);


        Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                refernce = database.getReference("games");
                String hostname = spinner.getSelectedItem().toString();
                String guestname = spinner2.getSelectedItem().toString();
                CollectHelperClass collect = new CollectHelperClass(hostname, guestname);
                refernce.push().setValue(collect);
                Context context = getApplicationContext();
                Toast.makeText(context, "Data added succesfully!", Toast.LENGTH_SHORT).show();
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



