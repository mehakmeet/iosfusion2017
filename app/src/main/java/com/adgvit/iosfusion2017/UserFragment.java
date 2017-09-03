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

public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    private ForumRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.userRecycler);
        adapter = new ForumRecyclerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment
        return rootView;
    }

    public List<ForumItem> getData(){
        List<ForumItem> data = new ArrayList<>();
        String[] questions = {"Yes this is a valid doubt", "Yes this module is working", "Hopefully it is working"};
        for (int i = 0; i < questions.length; i++) {
            ForumItem current = new ForumItem();
            current.question = questions[i];
            data.add(current);
        }
        return data;
    }

}
