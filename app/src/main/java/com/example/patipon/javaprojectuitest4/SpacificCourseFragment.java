package com.example.patipon.javaprojectuitest4;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import model.Course;
import model.Student;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpacificCourseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpacificCourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpacificCourseFragment extends Fragment implements Serializable {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView courseName;
    private TextView teacherName;
    private Course course;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @param param2 Parameter 2.
     * @return A new instance of fragment SpacificCourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpacificCourseFragment newInstance() {
        SpacificCourseFragment fragment = new SpacificCourseFragment();
        Bundle args = new Bundle();
        Bundle bundle = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public SpacificCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loadData();

        View rootView =inflater.inflate(R.layout.fragment_spacific_course, container, false);

        courseName = (TextView)rootView.findViewById(R.id.CourseName);
        courseName.setText(course.getCourseName());
        teacherName = (TextView)rootView.findViewById(R.id.TeacherName);
        teacherName.setText(course.getProfessorName());
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view_specific_course);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(rootView.getContext());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SpecificCourseRecyclerViewAdapter(loadData());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private Course loadData()
    {
        course = ((MainActivity)getActivity()).getCurrentCourse();
        System.out.println(course);
        return course;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
