package com.example.sasha.smarthcs;

import android.widget.ImageView;

public class Card {
    String name;
    int cost;
    ImageView picture;
    public Card(String _name, int _cost) {
        this.cost = _cost;
        this.name = _name;
    }
}
