package com.tulau.smartpark;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setItemBackgroundResource(R.color.localcolor);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = new LocalActivity();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment).commit();

//        Fragment fmLocal = new LocalActivity();
//        gotoTab(fmLocal);

    }
    @Override
    public void onBackPressed() {
    }

    private void gotoTab(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Local:
                    navigation.setItemBackgroundResource(R.color.localcolor);
                    Fragment fmLocal = new LocalActivity();
                    gotoTab(fmLocal);
                    return true;
                case R.id.navigation_list:
                    navigation.setItemBackgroundResource(R.color.listcolor);
                    Fragment fmList = new ListFragment();
                    gotoTab(fmList);
                    return true;
                case R.id.navigation_bike:
                    navigation.setItemBackgroundResource(R.color.bikecolor);
                    Fragment fmBike = new BikeFragment();
                    gotoTab(fmBike);
                    return true;
                case R.id.navigation_profile:
                    navigation.setItemBackgroundResource(R.color.profilecolor);
                    Fragment mProfile = new ProfileActivity();
                    gotoTab(mProfile);

                    return true;
            }
            return false;
        }

    };

}
