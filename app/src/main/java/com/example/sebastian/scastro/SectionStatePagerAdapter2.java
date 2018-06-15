package com.example.sebastian.scastro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 16.05.2018.
 */

public class SectionStatePagerAdapter2 extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();


    public SectionStatePagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public float getPageWidth(int position) {
        if (position == 0) {
            return(0.5f);
        } else {
            return (1.0f);
        }
    }
}
