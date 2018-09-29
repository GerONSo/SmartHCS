package com.example.sasha.smarthcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Card> cards = new ArrayList<>();
    static ArrayList<User> user_base = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        String message = "start login";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        User user = new User();
        user.set_login("keker");
        user.set_password("123");
        TextView login = findViewById(R.id.textlogin);
        login.setTextSize(25);
        login.setText(user.login);
        RecyclerView bill_list = findViewById(R.id.biil_list);
        cards.add(new Card("Вода", 45));
        cards.add(new Card("Газ", 46));
        cards.add(new Card("Электричество", 47));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getResources());
        bill_list.setAdapter(adapter);
    }
    public void buy(View view)
    {
        //Toast.makeText(getApplicationContext(), "Оплата...", Toast.LENGTH_LONG).show();

    }
}
