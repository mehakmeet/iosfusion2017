package com.adgvit.iosfusion2017;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ForumRecyclerAdapter extends RecyclerView.Adapter<ForumRecyclerAdapter.MyViewHolder>{
    LayoutInflater inflater;
    List<ForumItem> data = new ArrayList<>();

    public ForumRecyclerAdapter(Context context, List<ForumItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.forum_row_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ForumItem current = data.get(position);
        holder.doubt.setText(current.question);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        
        TextView doubt;
        ImageButton upVote;

        public MyViewHolder(View itemView) {
            super(itemView);
            doubt = (TextView) itemView.findViewById(R.id.ques);
            upVote = (ImageButton) itemView.findViewById(R.id.upVote);
        }
    }
}
