package com.example.patipon.javaprojectuitest4;


import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import model.Course;
import model.Student;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks,infoFragment.OnFragmentInteractionListener,SpacificCourseFragment.OnFragmentInteractionListener,CourseFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,NotificationFragment.OnFragmentInteractionListener,CalendarFragment.OnFragmentInteractionListener,QandAFragment.OnFragmentInteractionListener,SettingFragment.OnFragmentInteractionListener{


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    private Student student;
    private Course currentCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadStudent();
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position){
            case 0:
                fragment = new NotificationFragment();
                break;
            case 1:
                fragment = new ProfileFragment();
                break;
            case 2:
                fragment = new CalendarFragment();
                break;
            case 3:
                fragment = new QandAFragment();
                break;
            case 4:
                fragment = new SettingFragment();
                break;


        }
        fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();

    }

    public void setmToolbarColor(int color)
    {
        mToolbar.setBackgroundColor(color);
    }


    private void loadStudent()
    {
        student = new Student("patipon riebpradit", 19,12,123456768);
        System.out.println(student.getStudentId());
        student.addCourse(new Course("Matheematic 3", "AJ. Ko", 0001));
        student.addCourse(new Course("Data Structure", "AJ. Tarak", 0002));
        student.addCourse(new Course("AOOP", "AJ. Veera", 0003));
    }
    public Student getStudent()
    {
        return student;
    }

    public Context getContext()
    {
        return getContext();
    }


    public void switchContent(int id, Fragment fragment)
    {
        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction()
                .replace(id, fragment)
                .commit();
    }

    public void setCurrentCourse(Course c)
    {
        currentCourse = c;
    }
    public Course getCurrentCourse()
    {
        return currentCourse;
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
