package com.example.patipon.javaprojectuitest4;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Course;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Course> mDataset;
    private static MyClickListener myClickListener;
    private Context context;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;


        public DataObjectHolder(View itemView) {
            super(itemView);

            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public CourseRecyclerViewAdapter(ArrayList<Course> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(final ViewGroup parent,
                                               int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_course_fragment, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        holder.label.setText(mDataset.get(position).getCourseName());
        holder.dateTime.setText(mDataset.get(position).getProfessorName());

        //MainActivity mainActivity = (MainActivity)context;
        System.out.println("CHECK : " + mDataset.get(position));


        holder.label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)context;
                mainActivity.setCurrentCourse(mDataset.get(position));
                changeFragment(mDataset.get(position));
            }
        });
    }
    private void changeFragment(Course val)
    {
        SpacificCourseFragment fragment = SpacificCourseFragment.newInstance();
        Bundle mBundle = new Bundle();
        switchContent(R.id.container, fragment);
    }

    private void switchContent(int id , SpacificCourseFragment fragment)
    {
       if (fragment == null)
           return;
        if (context instanceof MainActivity){
            MainActivity mainActivity = (MainActivity) context;
            SpacificCourseFragment fragment1 = fragment;
            mainActivity.switchContent(id,fragment);
        }
    }
    public void addItem(Course dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
