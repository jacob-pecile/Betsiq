package com.betsiq_server.betsiq;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class Group extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);

        View footer = findViewById(R.id.footer);
        Button currentPage = (Button)footer.findViewById(R.id.menu_mylist);
        currentPage.setTextColor(Color.WHITE);
        currentPage.setEnabled(false);

        Button joinGroup =(Button)findViewById(R.id.join_group);
        Button goBack = (Button)findViewById(R.id.back_grouplist);

        TextView groupname = (TextView)findViewById(R.id.groupname);
        TextView groupentry = (TextView)findViewById(R.id.groupentry);
        TextView groupprize = (TextView)findViewById(R.id.groupprize);
        TextView groupwinners = (TextView)findViewById(R.id.groupwinners);

        // Get group info
        Intent intent = getIntent();

        // Assign each info




    }

    public  void submitJoin(View v){


    }

    public  void goBack(View v){
        finish();
    }


}
