package com.adgvit.iosfusion2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Wifi extends Fragment {

    public TextView WifiUserName, WifiPassWord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wifilayout, container, false);
        WifiUserName = (TextView) rootView.findViewById(R.id.id);
        WifiPassWord = (TextView) rootView.findViewById(R.id.password);

        //GET function
        //Replace both UserName and PassWord using Retrofit
        return rootView;
    }
}
