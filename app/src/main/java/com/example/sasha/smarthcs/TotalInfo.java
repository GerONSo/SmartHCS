package com.example.sasha.smarthcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class TotalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_info);
        int j = MainActivity.index;
        ArrayList<Bill> history = MainActivity.user_base.get(j).getHistory();
        Bill last = history.get(history.size() - 1);
        int cost = last.sum_g + last.sum_w + last.sum_l;
        TextView resource = findViewById(R.id.resource_t);
        resource.setTextSize(27);
        resource.setText("К оплате:");
        TextView sum = findViewById(R.id.sum_t);
        sum.setTextSize(27);
        sum.setText(Integer.toString(cost) + " Рублей");
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter5 adapter = new RecyclerViewAdapter5(getResources());
        bill_list.setAdapter(adapter);
    }
}
