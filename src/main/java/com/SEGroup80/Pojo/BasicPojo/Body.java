package com.SEGroup80.Pojo.BasicPojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Body {
    private double weight;
    private double height;
    private double bust; //胸围
    private double waist; //腰围
    private double hip; //臀围
    private double BMI;
    private String timePoint;

    public Body(double weight, double height, double bust, double waist, double hip, double BMI, String timePoint) {
        this.weight = weight;
        this.height = height;
        this.bust = bust;
        this.waist = waist;
        this.hip = hip;
        this.BMI = BMI;
        this.timePoint = timePoint;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBust() {
        return bust;
    }

    public double getWaist() {
        return waist;
    }

    public double getHip() {
        return hip;
    }

    public double getBMI() {
        return BMI;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBust(double bust) {
        this.bust = bust;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }
}
