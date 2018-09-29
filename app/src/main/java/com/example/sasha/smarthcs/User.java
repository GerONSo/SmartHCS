package com.example.sasha.smarthcs;

import java.util.ArrayList;

public class User {
    String login = "", password = "";
    ArrayList<Bill> history;
    public void set_login(String LOGIN)
    {
        this.login = LOGIN;
    }
    public void set_password(String PASSWORD)
    {
        this.password = PASSWORD;
    }
}