package com.operatingsystem.meracoid.processmanager;

import android.app.ListActivity;
import java.util.List;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.net.TrafficStats;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class processes extends ListActivity {
    private static final String TAG = "ProcessActivity";
    List<RunningAppProcessInfo> runningProcesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        runningProcesses = manager.getRunningAppProcesses();
        if(runningProcesses != null && runningProcesses.size() > 0){
            setListAdapter(new ListAdapter(this, runningProcesses));
        }else{
            Toast.makeText(getApplicationContext(), "No application is running", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onListItemClick(ListView I, View v, int position, long id){
        int pid = ((RunningAppProcessInfo)getListAdapter().getItem(position)).pid;

        android.os.Process.killProcess(pid);

        Toast.makeText(getApplicationContext(), "PID : " + pid + " has been killed.", Toast.LENGTH_LONG).show();
    }
}
