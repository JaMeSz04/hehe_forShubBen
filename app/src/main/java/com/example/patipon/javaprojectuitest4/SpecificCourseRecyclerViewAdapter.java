package com.example.patipon.javaprojectuitest4;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import model.Course;
import model.Student;

public class SpecificCourseRecyclerViewAdapter extends RecyclerView.Adapter<SpecificCourseRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private Map<Student,Double> mDataset;
    private static MyClickListener myClickListener;
    private Course course;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView Score;


        public DataObjectHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.StudentName);
            Score = (TextView) itemView.findViewById(R.id.score);

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

    public SpecificCourseRecyclerViewAdapter(Course myDataset) {
        course = myDataset;
        mDataset = course.getAllRank();
    }

    @Override
    public DataObjectHolder onCreateViewHolder(final ViewGroup parent,
                                               int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_rc2, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        int count = 0;
        for (Map.Entry<Student, Double> entry : mDataset.entrySet()) {
            if (count == position) {
                holder.name.setText(entry.getKey().getName());
                holder.Score.setText(Double.toString(entry.getValue()).substring(0,2));
            }
            count++;
        }

    }




    public void addItem(Student dataObj,double dataObj2, int index) {
        mDataset.put(dataObj, dataObj2);
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
