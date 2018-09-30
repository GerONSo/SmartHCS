package com.example.sasha.smarthcs;

import java.util.ArrayList;

public class User {
    public User(String login, String password, ArrayList<Bill> history) {
        this.login = login;
        this.password = password;
        this.history = history;
    }

    private String login = "", password = "";
    private ArrayList<Bill> history;

    public void set_login(String LOGIN)
    {
        this.login = LOGIN;
    }
    public void set_password(String PASSWORD)
    {
        this.password = PASSWORD;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Bill> getHistory() {
        return history;
    }
}