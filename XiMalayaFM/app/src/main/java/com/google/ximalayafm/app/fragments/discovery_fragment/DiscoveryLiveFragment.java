package com.google.ximalayafm.app.fragments.discovery_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.ximalayafm.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryLiveFragment extends Fragment {


    public DiscoveryLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discovery_live, container, false);
    }


}
