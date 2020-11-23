package com.example.basketballmanagerv3;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}