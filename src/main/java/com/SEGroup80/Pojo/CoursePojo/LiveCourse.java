package com.SEGroup80.Pojo.CoursePojo;

import java.util.ArrayList;

public class LiveCourse extends Course{
    private ArrayList<String> paticipate;   //实际到课的学员名单
    private ArrayList<Integer> timeTable;   //直播课时间表



    public ArrayList<String> getPaticipate() {
        return paticipate;
    }

    public int getPaticipateNum() {
        return paticipate.size();
    }

    public void addPaticipate(String trainerID) {
        this.paticipate.add(trainerID);
    }

    public ArrayList<Integer> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(ArrayList<Integer> timeTable) {
        this.timeTable = timeTable;
    }
}
