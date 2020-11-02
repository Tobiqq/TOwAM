package com.example.basketballmanagerv3;
<<<<<<< HEAD

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
>>>>>>> 5076573... Second Commit

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.team_manager);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.team_manager:
                        return true;
                    case R.id.game_manager:
                        startActivity(new Intent(getApplicationContext(), GameManager.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), Settings.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
=======
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
    bottomnav.setOnNavigationItemSelectedListener(navListener);

    this.setTitle("Basketball Team Manager");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch(menuItem.getItemId()) {
                case R.id.team_manager:
                    selectedFragment = new Fragment1();
                    break;
                case R.id.game_manager:
                    selectedFragment = new Fragment2();
                    break;
                case R.id.settings:
                    selectedFragment = new Fragment3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_bottom_navigation, selectedFragment).commit();

            return true;

        }
    };


>>>>>>> 5076573... Second Commit
}