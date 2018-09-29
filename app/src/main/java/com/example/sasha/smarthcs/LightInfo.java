package com.example.sasha.smarthcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class LightInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_info);
        int j = MainActivity.index;
        ArrayList<Bill> history = MainActivity.user_base.get(j).history;
        Bill last = history.get(history.size() - 1);
        int w = last.sum_l;
        double cost = MainActivity.light_resurse(w);
        int first = (int)(cost);
        int second = (int)((cost - first) * 100);
        String res = Integer.toString(first) + "." + Integer.toString(second) + " МВт/Ч";
    }
}
