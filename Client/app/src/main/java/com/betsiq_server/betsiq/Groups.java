package com.betsiq_server.betsiq;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.betsiq_server.betsiq.Adapters.GroupAdapter;
import com.betsiq_server.betsiq.Adapters.topSongAdapter;
import com.betsiq_server.betsiq.CoreClasses.Constants;
import com.betsiq_server.betsiq.CoreClasses.Group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jacob on 27/01/2017.
 */

public class Groups extends MenuActivity {

    private GroupAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups);

        View footer = findViewById(R.id.footer);
        Button currentPage = (Button)footer.findViewById(R.id.menu_Groups);
        currentPage.setTextColor(Color.WHITE);
        currentPage.setEnabled(false);

        ListView groupList = (ListView)findViewById(R.id.grouplist);

        String user = Constants.GetSharedPrefrences(getApplicationContext(), getResources().getString(R.string.USER));

        List<Group> Groups =  new ArrayList<Group>();
        Groups.add(new Group("Group 1", 5, new Date(), "02/22/2017", 50,3));
        Groups.add(new Group("Group 2", 10, new Date(), "02/22/2017", 100, 2));
        Groups.add(new Group("Group 3", 100, new Date(), "02/22/2017", 1000, 1));

        _adapter = new GroupAdapter(this, Groups);
        groupList.setAdapter(_adapter);
    }

    public void openFilters(View v){

        LayoutInflater inflater = getLayoutInflater();
        final View filters = inflater.inflate(R.layout.filter_dialog, null);

        new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle)
        .setView(filters)
        .setTitle("Filters")
        .setPositiveButton("Confirm",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                //TODO: validation on min and max
                String min = ((EditText)filters.findViewById(R.id.min)).getText().toString();
                String max = ((EditText)filters.findViewById(R.id.max)).getText().toString();

                RadioGroup radioButtonGroup = (RadioGroup)filters.findViewById(R.id.sortGroup);
                final int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();

                _adapter.getFilter().filter(min + ';' + max, new Filter.FilterListener() {
                    @Override
                    public void onFilterComplete(int count) {
                        if (radioButtonID >= 0)
                            _adapter.sortList(radioButtonID);
                    }
                });

            }
        })
        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                // if this button is clicked, just close
                // the dialog box and do nothing
                dialog.cancel();
            }
        })
        .show();
    }
}
