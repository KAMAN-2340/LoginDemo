package com.example.kevin.logindemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nick on 2/26/2018.
 */

public class ShelterDatabaseAdapter extends RecyclerView.Adapter<ShelterDatabaseAdapter.ViewHolder> {

    private ArrayList<Shelter> shelters;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ShelterItemClickListener shelterItemClickListener;
        public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
        }

        public void setShelterItemClickListener(ShelterItemClickListener shelterItemClickListener) {
            this.shelterItemClickListener = shelterItemClickListener;
        }

        @Override
        public void onClick(View view) {
            shelterItemClickListener.onClick(view, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            shelterItemClickListener.onClick(view, getAdapterPosition(), true);
            return true;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ShelterDatabaseAdapter(ArrayList shelters, Context context) {
        this.shelters = shelters;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ShelterDatabaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shelter_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(shelters.get(position).getName());

        holder.setShelterItemClickListener(new ShelterItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClicked) {
                Intent intent = new Intent(context, ShelterInformationActivity.class)
                        .putExtra("SHELTER", shelters.get(position));
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return shelters.size();
    }
}
