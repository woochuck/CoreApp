package com.luczak.m.coreapp.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.luczak.m.coreapp.interaction.ActivityInteractions;

public class BaseFragment extends Fragment {
    ActivityInteractions actions;

    @Nullable
    public ActivityInteractions getActions() {
        return actions;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            actions = (ActivityInteractions) context;
        } catch (Exception e) {
            throw new IllegalStateException(e.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        actions = null;
    }
}
