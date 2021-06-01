package com.SEGroup80.IO;

import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.CoursePojo.LiveCourse;
import com.SEGroup80.Pojo.CoursePojo.RecordCourse;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;

/**
 * Title: CourseJSONFileProcessor
 * This class is used to process JSON file for courses
 * @author SEGroup80
 */

public class CourseJSONFileProcessor {

    final static private String LiveCourseFileURL = "src/main/resources/com/SEGroup80/CourseFile/LiveCourseFile.txt";
    final static private String RecCourseFileURL = "src/main/resources/com/SEGroup80/CourseFile/RecCourseFile.txt";

    /**
     * This method transform the course data into the JSON format then write it to the file
     * @param course The course information
     */
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

    /**
     * This method read from JSON file to find and return the Course information with one particular course ID
     * @param courseID The course's ID
     * @return The object Course containing course information
     */
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

    /**
     * This method delete the course information with one particular course ID from the JSON file
     * @param courseID A course's ID
     * @throws IOException An exception occur when deleting a course information
     */
    public void deleteCourse(String courseID) throws IOException {

        new FileProcessor().removeLine(RecCourseFileURL, courseID);
    }

    // TODO: Finish

    /**
     * This method read from JSON file to find and return all the Courses' information
     * @return An arraylist of course information
     * @throws IOException An exception occur when reading all courses' information
     */
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
