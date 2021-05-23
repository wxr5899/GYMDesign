package com.SEGroup80.Pojo.BasicPojo;

import java.util.ArrayList;

public class Book {

    private String date;
    private ArrayList<Integer> timeTable;

    public Book() {
    }

    public Book(String date, ArrayList<Integer> timeTable) {
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
                "date='" + date + '\'' +
                ", timeTable=" + timeTable +
                '}';
    }
}
