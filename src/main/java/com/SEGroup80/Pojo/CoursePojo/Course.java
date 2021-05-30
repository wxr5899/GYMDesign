package com.SEGroup80.Pojo.CoursePojo;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Trainer;

import java.util.ArrayList;

//一个course包含多个video
//不太清楚 1.报名 2.开课 3.将视频放入课程中 三者的顺序
public class Course {

    private ArrayList<String> coachList;
    private String courseName;
    private String courseID;
    private String identity;
    private ArrayList<String> trainerList;
    private String photoURL;

    public Course() {
    }

    public Course(ArrayList<String> coachList, String courseName, String identity, ArrayList<String> trainerList) {
        this.coachList = coachList;
        this.courseName = courseName;

        if ("Live".equals(identity)) {
            this.courseID = "L" + System.currentTimeMillis();
        } else if ("Record".equals(identity)) {
            this.courseID = "R" + System.currentTimeMillis();
        } else {
            System.out.println("====== The identity is not valid! ======");
        }

        this.identity = identity;
        this.trainerList = trainerList;
    }

    public ArrayList<String> getCoachList() {
        return coachList;
    }

    public void setCoachList(ArrayList<String> coachList) {
        this.coachList = coachList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public ArrayList<String> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(ArrayList<String> trainerList) {
        this.trainerList = trainerList;
    }


    /**
     * This method gets the course cover's url
     * @return The course cover's url
     */
    public String getPhotoURL() {
        return photoURL;
    }

    /**
     * This method sets course cover
     * @param photoURL The course cover's url
     */
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
