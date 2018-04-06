package com.example.kevin.logindemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 2/26/2018.
 */

public class ShelterDatabaseAdapter extends RecyclerView.Adapter<ShelterDatabaseAdapter.ViewHolder>
        implements Filterable{

    private final List<Shelter> shelters;
    private List<Shelter> filteredShelters;
    private final Context context;

    private static final String TAG = "ShelterDatabaseAdapter";

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                filteredShelters = ShelterFilter.filter(charSequence, shelters);
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredShelters;
                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredShelters = (ArrayList<Shelter>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        public ShelterItemClickListener shelterItemClickListener;
        public final TextView mTextView;

        /**
         *
         * @param v
         */
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
        }

        /**
         * sets the shelter item click listener
         *
         * @param shelterItemClickListener the listener
         */
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

    /**
     * adapts shelter database
     *
     * @param shelters list of shelters
     * @param filteredShelters list of filtered shelters
     * @param context the current settings
     */
    @SuppressWarnings("unchecked")
    public ShelterDatabaseAdapter(List shelters, List filteredShelters, Context context) {
        this.shelters = shelters;
        this.filteredShelters = filteredShelters;
        this.context = context;
    }

    @Override
    public ShelterDatabaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shelter_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(filteredShelters.get(position).getName());

        holder.setShelterItemClickListener(new ShelterItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClicked) {
                Intent intent = new Intent(context, ShelterInformationActivity.class)
                        .putExtra("SHELTER", filteredShelters.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredShelters.size();
    }
}
