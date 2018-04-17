package com.operatingsystem.meracoid.processmanager;

/**
 * Created by meracoid on 4/14/18.
 */

import java.util.List;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ListAdapter extends ArrayAdapter<RunningAppProcessInfo> {
    private final Context context;
    private final List<RunningAppProcessInfo> values;

    public ListAdapter(Context context, List<RunningAppProcessInfo> values){
        super(context, R.layout.activity_processes, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_processes, parent, false);

        TextView appName = (TextView) rowView.findViewById(R.id.appNameText);
        appName.setText(values.get(position).processName);

        return rowView;
    }
}
