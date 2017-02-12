package com.betsiq_server.betsiq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Jacob on 03/02/2017.
 */

public abstract class MenuActivity extends Activity {

    public void gotoHundred(View view){
        Intent startIntent = new Intent(this, topHundred.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startIntent);
    }

    public void gotoMylist(View view){
        Intent startIntent = new Intent(this, myList.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startIntent);
    }

    public void gotoGroups(View view){
        Intent startIntent = new Intent(this, Groups.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startIntent);
    }

    public void gotoMoney(View view){
        Intent startIntent = new Intent(this, earnMoney.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startIntent);
    }

    public void gotoSettings(View view){
        Intent startIntent = new Intent(this, Settings.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startIntent);
    }
}
