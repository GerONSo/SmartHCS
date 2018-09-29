package com.example.sasha.smarthcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
        String res = Integer.toString(first) + "." + (Integer.toString(second).length() == 1 ? "0" : "") + Integer.toString(second) + " МВт/Ч";
        TextView resource = findViewById(R.id.resource_l);
        resource.setTextSize(30);
        resource.setText(res);
        TextView sum = findViewById(R.id.sum_l);
        sum.setTextSize(30);
        sum.setText(Integer.toString(last.sum_l) + " Рублей");
    }
}
