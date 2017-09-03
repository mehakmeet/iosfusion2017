package com.adgvit.iosfusion2017;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ForumFragment extends Fragment {

    public RecyclerView recyclerView;
    public ForumRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forum, container, false);
        recyclerView  = (RecyclerView) rootView.findViewById(R.id.forumRecycler);
        adapter = new ForumRecyclerAdapter(getActivity(), getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    public List<ForumItem> getData(){
        List<ForumItem> data = new ArrayList<>();
        String[] questions = {"Is this a valid doubt?", "Is this module working?", "Please let it work"};
        for (int i = 0; i < questions.length; i++) {
            ForumItem current = new ForumItem();
            current.question = questions[i];
            data.add(current);
        }
        return data;
    }

}
