package com.sugar.boilerplate.NestedFragment.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sbrukhanda.fragmentviewpager.FragmentVisibilityListener;
import com.sugar.boilerplate.NestedFragment.activities.NestedMainActivity;
import com.sugar.boilerplate.R;


public class SimpleFragment extends Fragment implements FragmentVisibilityListener
{

    private static final String EXTRA_FRAGMENT_NAME = "EXTRA_FRAGMENT_NAME";
    private TextView mNameLabel;
    private String mName;
    // *********************************************************************************************
    public SimpleFragment() {
        // Mandatory empty public constructor
    }

    // *********************************************************************************************
    public static SimpleFragment newInstance(String fragmentName) {
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_FRAGMENT_NAME, fragmentName);

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    // *********************************************************************************************
    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.nested_fragment_simple, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            mName = arguments.getString(EXTRA_FRAGMENT_NAME);
        }

        mNameLabel = (TextView) fragment.findViewById(R.id.lbl_name);
        mNameLabel.setText(mName);

        return fragment;
    }

    // *********************************************************************************************
    @Override
    public void onFragmentVisible() {
        if (getActivity() != null) {
            ((NestedMainActivity) getActivity()).logMessage(mName + " is visible.");
        }

        //mWorkThread = new WorkThread(mName);
        //mWorkThread.start();
    }

    // *********************************************************************************************
    @Override
    public void onFragmentInvisible() {
        if (getActivity() != null) {
            ((NestedMainActivity) getActivity()).logMessage(mName + " is invisible.");
        }

        //mWorkThread.cancel();
        //mWorkThread = null;
    }
}