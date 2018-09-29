package com.example.sasha.smarthcs;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Resources resources;

    public RecyclerViewAdapter(Resources resources) {
        this.resources = resources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setTextSize(20);
        viewHolder.cost.setTextSize(20);
        viewHolder.name.setText(ProfileActivity.cards.get(i).name);
        viewHolder.cost.setText(Integer.toString(ProfileActivity.cards.get(i).cost));
        if (i == 0) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.water));
        if (i == 1) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.gaz));
        if (i == 2) viewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.light));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        View view;
        TextView name;
        TextView cost;
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            icon = view.findViewById(R.id.icon);
            cost = view.findViewById(R.id.cost);
            name = view.findViewById(R.id.name);
        }
    }
}
