package com.betsiq_server.betsiq.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.betsiq_server.betsiq.CoreClasses.Group;
import com.betsiq_server.betsiq.CoreClasses.Song;
import com.betsiq_server.betsiq.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jacob on 22/02/2017.
 */

public class GroupAdapter extends BaseAdapter implements Filterable {
    private List<Group> OriginalGroups;
    private List<Group> Groups;
    private Activity Context;
    private GroupFilter GFilter;

    public GroupAdapter(Activity context, List<Group> groups){
        this.OriginalGroups = new ArrayList<Group>(groups);
        this.Groups = groups;
        this.Context = context;
        this.GFilter = new GroupFilter(this);
    }

    @Override
    public int getCount() {
        return Groups.size();
    }

    @Override
    public Group getItem(int position) {
        return Groups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public List<Group> getOriginalGroups() {
        return OriginalGroups;
    }

    public List<Group> getGroups() {
        return Groups;
    }

    public void setGroups(List<Group> groups) {
        Groups = groups;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        // re-use an existing view, if one is available
        // otherwise create a new one
        if (view == null)
        {
            view = LayoutInflater.from(Context).inflate(R.layout.group, parent, false);
        }

        Group item = this.Groups.get(position);

        TextView name = (TextView)view.findViewById(R.id.groupname);
        name.setText(item.getName());
        TextView entry = (TextView)view.findViewById(R.id.groupentry);
        entry.setText("entry: $" + Integer.toString(item.getEntryFee()));
        TextView prize = (TextView)view.findViewById(R.id.groupprize);
        prize.setText("prize: $" + Integer.toString(item.getPrize()));
        TextView winners = (TextView)view.findViewById(R.id.groupwinners);
        winners.setText("number of winners: " + Integer.toString(item.getWinners()));
        TextView end = (TextView)view.findViewById(R.id.groupend);
        end.setText(item.getEnd());

        return view;
    }

    public void sortList(final int key){
        Collections.sort(this.getGroups(),new Comparator<Group>() {
            @Override
            public int compare(Group one, Group two) {
                int a = one.getEntryFee();
                int b = two.getEntryFee();
                if (key == R.id.asc){
                    return a < b ? -1
                            : a > b ? 1
                            : 0;
                }else{
                    return a > b ? -1
                            : a < b ? 1
                            : 0;
                }
            }
        });
    }

    public GroupFilter getFilter() {
        return GFilter;
    }

    public class GroupFilter extends Filter {

        private GroupAdapter _adapter;

        public GroupFilter(GroupAdapter adapter){
            this._adapter = adapter;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            this._adapter.setGroups((List<Group>) results.values);
            this._adapter.notifyDataSetChanged();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String[] range = constraint.toString().split(";");
            int min = Integer.parseInt(range[0]);
            int max = Integer.parseInt(range[1]);

            FilterResults results = new FilterResults();
            List<Group> FilteredArrayNames = new ArrayList<Group>(_adapter.getOriginalGroups());

            // perform your search here using the searchConstraint String.

            for (int i = 0; i < FilteredArrayNames.size(); i++) {
                Group current = FilteredArrayNames.get(i);
                if (current.getEntryFee() < min || current.getEntryFee() > max) {
                    FilteredArrayNames.remove(current);
                }
            }

            results.count = FilteredArrayNames.size();
            results.values = FilteredArrayNames;

            return results;
        }
    }
}
