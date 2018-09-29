package com.example.sasha.smarthcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Card> cards = new ArrayList<>();
    static ArrayList<User> user_base = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.login_button);
        final EditText loginText = findViewById(R.id.login_text);
        EditText passwordText = findViewById(R.id.password_text);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cur_name = loginText.getText().toString();
                String cur_password = loginText.getText().toString();
                ArrayList<User> users = ProfileActivity.user_base;
                for(int i = 0; i < users.size(); i++) {
                    if(cur_name.equals(users.get(i).getLogin()) && cur_password.equals(users.get(i).getPassword())) {
                        openProfile();
                    }
                }
            }
        });
    }

//    void openProfile() {
//        Intent intent = new Intent(this, ProfileActivity.class);
//        startActivity(intent);
//    }
}
