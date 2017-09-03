package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Timeline extends Fragment {

    private String[] day={"Day 1","Day 1","Day 1","Day 1","Day 1"};

    private String[] times={"9:00-10:00","10:00-11:00","11:00-12:00","1:00-2:00","2:00-3:00"};

    private String[] title={"Welcome to ios Fusion","Breakfast ready","Snacks ready","Get set code","Snacks ready"};

    private String[] details={"Instruction1","Instruction2","Instruction3","Instruction4","Instruction5"};

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TimelineAdapter tAdaapter;
    ArrayList<TimelineItems> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.timelinelayout, container, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recycle);
        int count = 0;
        for(String Name: title)
        {
            arrayList.add(new TimelineItems(day[count],times[count],Name,details[count]));
            count++;
        }
        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        tAdaapter=new TimelineAdapter(arrayList,getActivity());
        recyclerView.setAdapter(tAdaapter);
        return rootView;
    }
}
