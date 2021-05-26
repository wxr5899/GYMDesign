package com.SEGroup80.Pojo.BasicPojo;

import com.SEGroup80.Pojo.UserPojo.Trainer;

import java.util.ArrayList;

public class Book {

    private String trainerID;
    private String coachID;
    private String date;
    private ArrayList<Integer> timeTable;

    public Book() {
    }

//    public Book(String date, ArrayList<Integer> timeTable) {
//        this.date = date;
//        this.timeTable = timeTable;
//    }

    public Book(String trainerID, String coachID, String date, ArrayList<Integer> timeTable) {
        this.trainerID = trainerID;
        this.coachID = coachID;
        this.date = date;
        this.timeTable = timeTable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Integer> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(ArrayList<Integer> timeTable) {
        this.timeTable = timeTable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "trainerID='" + trainerID + '\'' +
                ", coachID='" + coachID + '\'' +
                ", date='" + date + '\'' +
                ", timeTable=" + timeTable +
                '}';
    }
}
