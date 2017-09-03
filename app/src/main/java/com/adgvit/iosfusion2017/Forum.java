package com.adgvit.iosfusion2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Forum extends Fragment {

    private TabLayout tabs;
    private ViewPager pager;
    private EditText doubt;
    private Button Send;
    private ForumFragPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.forumlayout, container, false);

        tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        doubt = (EditText) rootView.findViewById(R.id.doubt);
        Send = (Button) rootView.findViewById(R.id.send);
        adapter = new ForumFragPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ques = doubt.getText().toString();
                //POST ques to server
            }
        });
        return rootView;
    }
}
