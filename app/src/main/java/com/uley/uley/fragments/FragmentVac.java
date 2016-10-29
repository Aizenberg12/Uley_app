package com.uley.uley.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uley.uley.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVac extends Fragment {


    public FragmentVac() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_vac, container, false);
    }

}
