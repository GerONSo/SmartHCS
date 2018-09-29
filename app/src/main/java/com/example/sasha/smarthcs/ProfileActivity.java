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

import java.util.ArrayList;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {

    ArrayList<User> user_base = MainActivity.user_base;
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
        TextView login = findViewById(R.id.textlogin);
        login.setTextSize(15);
        login.setText(user.login);
        RecyclerView bill_list = findViewById(R.id.biil_list);
        MainActivity.cards.add(new Card("Вода", 145));
        MainActivity.cards.add(new Card("Газ", 347));
        MainActivity.cards.add(new Card("Электричество", 262));
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getResources());
        bill_list.setAdapter(adapter);
    }
    public void buy(View view)
    {
        Toast.makeText(getApplicationContext(), "Оплата...", Toast.LENGTH_LONG).show();
    }
}
