package com.jose.park_ok_colaborador.view.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.view.activities.QRcode.QrcodeClientDataActivity;
import com.jose.park_ok_colaborador.view.adapters.HomeViewPagerAdapter;
import com.jose.park_ok_colaborador.view.fragments.AttendanceFragment;
import com.jose.park_ok_colaborador.view.fragments.InputFragment;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MenuItem prevMenuItem;
    private BottomNavigationView mbnvMenu;
    private ViewPager mVpContent;
    private boolean auxQrcode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViewPager();

        mVpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    mbnvMenu.getMenu().getItem(0).setChecked(false);


                mbnvMenu.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mbnvMenu.getMenu().getItem(position);
            }


            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
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
        mbnvMenu = findViewById(R.id.bnv_menu);
        mVpContent = findViewById(R.id.vp_content);
        mbnvMenu.setOnNavigationItemSelectedListener(this);
        mVpContent.setAdapter(new HomeViewPagerAdapter(getSupportFragmentManager()));
        mVpContent.setCurrentItem(0,false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        auxQrcode =! auxQrcode;

        if (auxQrcode) {
            Intent intent = new Intent(HomeActivity.this, QrcodeClientDataActivity.class);
            startActivity(intent);

        } else {

            Intent i = new Intent(HomeActivity.this, ReportPlateActivity.class);
            startActivity(i);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("PARKOK", MODE_PRIVATE);
        int screenOrigin = preferences.getInt("SCREEN_ORIGEN",0);

        switch (screenOrigin ){
            case 1 :
                mVpContent.setCurrentItem(0,false);
                break;

            case 2:
                mVpContent.setCurrentItem(1,false);
               break;

            case 3:
                mVpContent.setCurrentItem(2,false);
                break;

            case 4:
                mVpContent.setCurrentItem(3,false);
                break;

        }
    }
}
