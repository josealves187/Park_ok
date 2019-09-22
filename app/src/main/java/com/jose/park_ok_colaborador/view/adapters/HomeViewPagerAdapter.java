package com.jose.park_ok_colaborador.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jose.park_ok_colaborador.view.fragments.AttendanceFragment;
import com.jose.park_ok_colaborador.view.fragments.HistoricFragment;
import com.jose.park_ok_colaborador.view.fragments.InputFragment;
import com.jose.park_ok_colaborador.view.fragments.ProfileFragment;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new InputFragment();
            case 1:
                return new AttendanceFragment();
            case 2:
                return new HistoricFragment();
            case 3:
                return new ProfileFragment();

        }
        return new InputFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
