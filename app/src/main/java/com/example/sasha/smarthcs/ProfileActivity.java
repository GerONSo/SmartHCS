package com.example.sasha.smarthcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;

import android.widget.EditText;

import ru.yandex.money.android.sdk.Amount;
import ru.yandex.money.android.sdk.Checkout;
import ru.yandex.money.android.sdk.Configuration;
import ru.yandex.money.android.sdk.PaymentMethodType;
import ru.yandex.money.android.sdk.ShopParameters;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {

    ArrayList<User> user_base = MainActivity.user_base;
    ArrayList<Bill> history = user_base.get(MainActivity.index).getHistory();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        Intent intent = new Intent(this, LoginActivity.class);
//        String message = "start login";
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
        int j = MainActivity.index;
        User user = user_base.get(j);
        Bill last = user.getHistory().get(user.getHistory().size() - 1);
        TextView login = findViewById(R.id.textlogin);
        login.setTextSize(15);
        login.setText(user.getLogin());
        RecyclerView bill_list = findViewById(R.id.biil_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getResources(), new RecyclerViewAdapter.OnResourceSelected() {
            @Override
            public void onResourcesSelected(int pos) {
                if(pos == 0) {
                    startWaterInfo();
                }
                else if(pos == 1) {
                    startGazInfo();
                }
                else if(pos == 2) {
                    startLightInfo();
                }
                else if(pos == 3) {
                    startTotalInfo();
                }
            }
        });
        bill_list.setAdapter(adapter);
        Checkout.attach(getSupportFragmentManager());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Checkout.detach();
    }

    public void buy(View view)
    {
        Toast.makeText(getApplicationContext(), "Оплата...", Toast.LENGTH_LONG).show();
        timeToStartCheckout();
    }

    void timeToStartCheckout() {

        Checkout.configureTestMode(
                new Configuration(
                        true,
                        true,
                        true,
                        1,
                        true,
                        true
                )
        );
        int sum = 0;
        Bill last = history.get(history.size() - 1);
        sum = sum + last.sum_g + last.sum_l + last.sum_w;
        Checkout.tokenize(
                this,
                new Amount(new BigDecimal(Integer.toString(sum)), Currency.getInstance("RUB")),
                new ShopParameters(
                        "Умный ЖКХ",
                        "Ростелеком!!!",
                        "47",
                        Collections.singleton(PaymentMethodType.BANK_CARD)
                )
        );
    }

    private void startWaterInfo() {
        Intent intent = new Intent(this, WaterInfo.class);
        startActivity(intent);
    }

    private void startLightInfo() {
        Intent intent = new Intent(this, LightInfo.class);
        startActivity(intent);
    }

    private void startGazInfo() {
        Intent intent = new Intent(this, GazInfo.class);
        startActivity(intent);
    }

    private void startTotalInfo() {
        Intent intent = new Intent(this, TotalInfo.class);
        startActivity(intent);
    }

    public void exit(View view)
    {
        Toast.makeText(getApplicationContext(), "Выход...", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
