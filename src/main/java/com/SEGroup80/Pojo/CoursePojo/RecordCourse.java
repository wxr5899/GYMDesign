package com.SEGroup80.Pojo.CoursePojo;

import java.util.ArrayList;

public class RecordCourse extends Course {

    private ArrayList<String> videoList;
    private String introduction;
    private double price;

    public RecordCourse() {

    }

    public RecordCourse(ArrayList<String> coachList, String courseName, String identity, ArrayList<String> trainerList, ArrayList<String> videoList, String introduction, double price) {
        super(coachList, courseName, identity, trainerList);
        this.videoList = videoList;
        this.introduction = introduction;
        this.price = price;
    }


    public ArrayList<String> getVideoList() {
        return videoList;
    }

    public void setVideoList(ArrayList<String> videoList) {
        this.videoList = videoList;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
