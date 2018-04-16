package com.example.kevin.logindemo;

import android.view.View;

/**
 * Created by Nick on 2/26/2018.
 * Shelter item click listener for long clicks
 */

public interface ShelterItemClickListener {
    void onClick(View view, int position, boolean isLongClicked);
}
