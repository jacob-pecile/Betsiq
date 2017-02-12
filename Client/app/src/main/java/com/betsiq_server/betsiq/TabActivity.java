package com.betsiq_server.betsiq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.betsiq_server.betsiq.Adapters.TabAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        String[] tabTitles = new String[]{"Top 100", "My List", "Groups", "Earn Money", "Settings"};
//        mViewPager = (ViewPager) findViewById(R.id.container);
//        List<Fragment> frags = new ArrayList<Fragment>();
//        frags.add(new topHundred());
//        frags.add(new myList());
//        frags.add(new Groups());
//        frags.add(new earnMoney());
//        frags.add(new Settings());
//        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), tabTitles, frags);
//        mViewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//
//    public void GoToTopHundred(View view){
//        Intent startIntent = new Intent(this, topHundred.class);
//        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(startIntent);
//    }
}
