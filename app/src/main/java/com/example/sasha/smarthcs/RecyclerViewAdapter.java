package com.example.sasha.smarthcs;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    interface OnResourceSelected {
        void onResourcesSelected(int pos);
    }

    Resources resources;
    private OnResourceSelected callback;

    public RecyclerViewAdapter(Resources resources, OnResourceSelected callback) {
        this.resources = resources;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(MainActivity.cards.get(i).name);
        viewHolder.cost.setText(Integer.toString(MainActivity.cards.get(i).cost) + " Рублей");
        if (i == 0) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.water));
        if (i == 1) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.gaz));
        if (i == 2) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.light));
        if (i == 3) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.rubles));
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onResourcesSelected(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return MainActivity.cards.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        View view;
        TextView name;
        TextView cost;
        ImageView icon;
        ImageView plus;

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            icon = view.findViewById(R.id.icon);
            cost = view.findViewById(R.id.cost);
            name = view.findViewById(R.id.name);
            plus = view.findViewById(R.id.plus);
        }
    }
}
