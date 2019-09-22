package com.jose.park_ok_colaborador.view.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.view.activities.QRcode.QRCodeReaderExitActivity;
import com.jose.park_ok_colaborador.view.activities.QRcode.QrcodeClientDataActivity;
import com.jose.park_ok_colaborador.view.adapters.HomeViewPagerAdapter;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mbnvMenu;
    private ViewPager mVpContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mbnvMenu = findViewById(R.id.bnv_menu);
        mVpContent = findViewById(R.id.vp_content);
        mbnvMenu.setOnNavigationItemSelectedListener(this);

        initViewPager();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_input:
                mVpContent.setCurrentItem(0,false);
                return true;

            case R.id.nav_attendance:
                mVpContent.setCurrentItem(1,false);
                return true;

            case R.id.nav_historic:
                mVpContent.setCurrentItem(2,false);
                return true;

            case R.id.nav_profile:
                mVpContent.setCurrentItem(3,false);
                return true;


        }

        return false;
    }

    private void initViewPager(){
        mVpContent.setAdapter(new HomeViewPagerAdapter(getSupportFragmentManager()));
        mVpContent.setCurrentItem(0,false);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (true){
            Intent intent = new Intent(HomeActivity.this,QrcodeClientDataActivity.class);
            startActivity(intent);
        }else {
            Intent i = new Intent(HomeActivity.this, QRCodeReaderExitActivity.class);
            startActivity(i);

        }

    }
}
