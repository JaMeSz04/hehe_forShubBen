/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Patipon
 */
public class Student extends Person {

    int studentId;
    StudentType type;
    int grade; //level
    private Map<Course, Double> courseList;
    Room room;

    public Student(String name, int age, int grade) {
        super(name, age);
        courseList = new HashMap<Course, Double>();
        generateUserId();
        generateType();
        generateRoom();

    }
    public Student(String name, int age, int grade, int studentId){
        super(name,age);
        this.studentId = studentId;
        generateType();
        generateRoom();
    }
    public void setStudentId(int id)
    {
        studentId = id;
    }

    public String getName()
    {
        return super.getName();
    }
    
    public double getScoreOf(Course c)
    {
        for (Map.Entry<Course, Double> entry : courseList.entrySet())
        {
            if (entry.getKey().equals(c))
            {
                return entry.getValue();
            }
        }
        return -1;
    }

    public double getGPS() {
        double sum = 0;
         for (Map.Entry<Course, Double> entry : courseList.entrySet())  {
            try {
                sum += entry.getKey().getActualGradeTarmGrain(this);
            } catch (IllegalArgumentException e) {
                return -1;
            }
        }
        return sum / courseList.size();
    }

    private void generateType() {
        if (grade < 7) {
            type = StudentType.PRIMARY;
        } else {
            type = StudentType.SECONDARY;
        }
    }

    private void generateRoom() {
        //
    }

    public Map<Course,Double> getCourses() {
        return courseList;
    }

    private void generateUserId() {
        //set value to studentID;
    }

    public void addCourse(Course c) {
        if (c.hasStudent(this)) {
            if (courseList.containsKey(c)) 
                throw new IllegalArgumentException("Student is already registered on this course");
            else
                courseList.put(c, 0.00);
            
            } else {
                if (courseList == null)
                    courseList = new HashMap<Course,Double>();
                courseList.put(c, 0.00);
                c.addStudent(this);
                
            }
        }

    public int getStudentId()
    {
        return studentId;
    }
}
