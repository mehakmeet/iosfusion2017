package com.adgvit.iosfusion2017;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.Viewholder> {

    ArrayList<TimelineItems> arrayList=new ArrayList<>();
    private Context context;

    public TimelineAdapter(ArrayList<TimelineItems> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public TimelineAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.timelinerow,parent,false);
        Viewholder viewholder=new Viewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(TimelineAdapter.Viewholder holder, int position) {
        holder.days.setText(arrayList.get(position).getDay());
        holder.times.setText(arrayList.get(position).getTime());
        holder.heads.setText(arrayList.get(position).getHeading());
        holder.desc.setText(arrayList.get(position).getDescrpt());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView days;
        public TextView times;
        public TextView heads;
        public TextView desc;

        public Viewholder(View itemView) {
            super(itemView);
            days= (TextView) itemView.findViewById(R.id.l1part);
            times= (TextView) itemView.findViewById(R.id.ltime);
            heads= (TextView) itemView.findViewById(R.id.r1part);
            desc= (TextView) itemView.findViewById(R.id.details);
        }
    }
}
