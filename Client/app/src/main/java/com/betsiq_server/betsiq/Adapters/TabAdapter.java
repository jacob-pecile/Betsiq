package com.betsiq_server.betsiq.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.betsiq_server.betsiq.Groups;
import com.betsiq_server.betsiq.Settings;
import com.betsiq_server.betsiq.earnMoney;
import com.betsiq_server.betsiq.myList;
import com.betsiq_server.betsiq.topHundred;


public class TabAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitles;

    public TabAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.tabTitles = titles;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                topHundred tab1 = new topHundred();
                return tab1;
            case 1:
                myList tab2 = new myList();
                return tab2;
            case 2:
                Groups tab3 = new Groups();
                return tab3;
            case 3:
                earnMoney tab4 = new earnMoney();
                return tab4;
            case 4:
                Settings tab5 = new Settings();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }
}