package com.example.patipon.javaprojectuitest4;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Course;
import model.Student;


public class ExpandListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<Notification> courses;


    public ExpandListAdapter(Context context,ArrayList<Notification> courses) {
            this.context = context;
        this.courses = courses;

    }

    @Override
    public int getGroupCount() {
        return this.courses.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Notification getGroup(int groupPosition) {
        return courses.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return courses.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle =  getGroup(groupPosition).getHeader();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_expand, null);
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.header_text);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = ((Notification)getChild(groupPosition, childPosition)).getContext();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item_expand, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.item_text);
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
