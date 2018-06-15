package com.example.sebastian.scastro;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.sebastian.scastro.databinding.Fragment1LayoutBinding;

/**
 * Created by Sebastian on 16.05.2018.
 */

public class Fragment1 extends Fragment {

    Fragment1LayoutBinding fragment1LayoutBinding;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragment1LayoutBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment1_layout, container, false);

        View view = fragment1LayoutBinding.getRoot();

        fragment1LayoutBinding.setSun(MainActivity.sun);

        return view;
    }
}
