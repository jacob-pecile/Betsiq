package com.betsiq_server.betsiq;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Jacob on 27/01/2017.
 */

public class Groups extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups);

        View footer = findViewById(R.id.footer);
        Button currentPage = (Button)footer.findViewById(R.id.menu_Groups);
        currentPage.setTextColor(Color.WHITE);
        currentPage.setEnabled(false);
    }
}
