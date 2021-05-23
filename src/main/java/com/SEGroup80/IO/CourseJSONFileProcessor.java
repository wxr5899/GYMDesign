package com.SEGroup80.IO;

import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.CoursePojo.LiveCourse;
import com.SEGroup80.Pojo.CoursePojo.RecordCourse;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;

public class CourseJSONFileProcessor {

    final static private String LiveCourseFileURL = "src/main/resources/com/SEGroup80/CourseFile/LiveCourseFile.txt";
    final static private String RecCourseFileURL = "src/main/resources/com/SEGroup80/CourseFile/RecCourseFile.txt";

    public void writeCourseJSON(Course course) {

        String jsonString = JSON.toJSONString(course);
        System.out.println(jsonString + "\n");

        String filePath = null;

        if ("Live".equals(course.getIdentity())) {
            filePath = LiveCourseFileURL;
        } else if ("Record".equals(course.getIdentity())) {
            filePath = RecCourseFileURL;
        } else {
            System.out.println("No such type of Course!");
        }

        if (filePath == null) {
            System.out.println("====== The identity of the User is not valid! ======");
        } else {
            new FileProcessor().writeToFile(filePath, jsonString);
        }

    }

    public Course readCourseJSON(String courseID) {

        ArrayList<Course> courseArrayList = new ArrayList<Course>();

        System.out.println("======Reading JSON File=====\n");

        String filePath = null;

        char identityType = courseID.charAt(0);

        if ('L' == identityType) {
            filePath = LiveCourseFileURL;
        } else if ('R' == identityType) {
            filePath = RecCourseFileURL;
        } else {
            System.out.println("The courseID is not correct!");
        }

        if (filePath == null) {

            System.out.println("====== The format of the UserID is not valid! ======");
        } else {
            File file = new File(filePath);

            try {

                FileInputStream fileInputStream = new FileInputStream(file);

                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = null;

                while ((line = bufferedReader.readLine()) != null) {

                    System.out.println(line);

                    Course course = null;

                    if ('L' == identityType) {
                        course = JSON.parseObject(line, LiveCourse.class);
                    } else {
                        course = JSON.parseObject(line, RecordCourse.class);
                    }

                    if (course.getCourseID().equals(courseID)) {

                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();

                        return course;
                    }
                }

                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;

    }


    public void deleteCourse(String courseID) throws IOException {

        new FileProcessor().removeLine(RecCourseFileURL, courseID);
    }

    // TODO: Finish

    public ArrayList<Course> readAllCourseJSON() throws IOException {

        File file = new File(RecCourseFileURL);

        FileInputStream fileInputStream = new FileInputStream(file);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

        ArrayList<Course> courseArrayList = new ArrayList<>();

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {

            System.out.println(line);

            Course course = null;

            course = JSON.parseObject(line, RecordCourse.class);


            courseArrayList.add(course);

            System.out.println(course.getCourseID());


        }


        return courseArrayList;

    }
}
