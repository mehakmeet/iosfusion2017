package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TrendingFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private ForumRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trending, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.trendingRecycler);
        adapter = new ForumRecyclerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    public List<ForumItem> getData() {
        List<ForumItem> data = new ArrayList<>();
        String[] questions = {"1st trending question", "2nd trending question", "3rd trending question"};
        for(int i = 0; i < questions.length; i++) {
            ForumItem current = new ForumItem();
            current.question = questions[i];
            data.add(current);
        }
        return data;
    }

}
