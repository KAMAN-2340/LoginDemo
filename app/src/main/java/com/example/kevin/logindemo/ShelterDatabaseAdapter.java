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

public class ShelterDatabaseAdapter extends RecyclerView.Adapter<ShelterDatabaseAdapter.ViewHolder> implements Filterable{

    private List<Shelter> shelters;
    private List<Shelter> filteredShelters;
    private Context context;

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString().toLowerCase();
                if (charSequenceString.isEmpty()) {
                    filteredShelters = shelters;
                } else {
                    if (charSequenceString.equals("male")) {
                        filteredShelters = ShelterDatabaseSearcher.searchMale(shelters);
                    } else if (charSequenceString.equals("female")) {
                        filteredShelters = ShelterDatabaseSearcher.searchFemale(shelters);
                    } else if (charSequenceString.equals("newborn")){
                        filteredShelters = ShelterDatabaseSearcher.searchNewborn(shelters);
                    } else if (charSequenceString.equals("family") || charSequence.equals("families")) {
                        filteredShelters = ShelterDatabaseSearcher.searchFamily(shelters);
                    } else if (charSequenceString.equals("families with newborns")) {
                        filteredShelters = ShelterDatabaseSearcher.searchFamiliesWithNewborns(shelters);
                    } else if (charSequenceString.equals("children")) {
                        filteredShelters = ShelterDatabaseSearcher.searchChildren(shelters);
                    } else if (charSequenceString.equals("young adults")) {
                        filteredShelters = ShelterDatabaseSearcher.searchYoungAdults(shelters);
                    } else if (charSequenceString.equals("anyone")) {
                        filteredShelters = ShelterDatabaseSearcher.searchAnyone(shelters);
                    } else {
                        filteredShelters = ShelterDatabaseSearcher.searchByName(shelters, charSequenceString);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredShelters;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredShelters =(ArrayList<Shelter>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

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

    public ShelterDatabaseAdapter(ArrayList shelters, ArrayList filteredShelters, Context context) {
        this.shelters = shelters;
        this.filteredShelters = filteredShelters;
        this.context = context;
    }

    @Override
    public ShelterDatabaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shelter_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
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
