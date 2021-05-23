package com.SEGroup80.Pojo.UserPojo;

import com.SEGroup80.Pojo.BasicPojo.Book;
import java.util.ArrayList;

public class Coach extends User{

    private String description;
    private ArrayList<Book> bookList;
    private ArrayList<String> courseList;

    public Coach() {

    }

    public Coach(String identity, String password, String name, String mail, String phoneNumber, int age, boolean sex) {
        super(identity, password, name, mail, phoneNumber, age, sex);
    }

    public Coach(String identity, String password, String name, String mail, String phoneNumber, int age, boolean sex, ArrayList<Book> bookList, ArrayList<String> courseList) {
        super(identity, password, name, mail, phoneNumber, age, sex);
        this.bookList = bookList;
        this.courseList = courseList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<String> courseList) {
        this.courseList = courseList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
