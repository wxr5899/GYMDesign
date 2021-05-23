package com.SEGroup80.Service;


import com.SEGroup80.IO.CourseJSONFileProcessor;
import com.SEGroup80.IO.UserJSONFileProcessor;
import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.CoursePojo.Course;

import java.io.IOException;
import java.util.ArrayList;

public class SearchService {

    public ArrayList<Object> SearchUser(String userID, int num){
        return new UserJSONFileProcessor().readJSON(userID, num);
    }

    public Course SearchCourse(String courseID) {
        return new CourseJSONFileProcessor().readCourseJSON(courseID);
    }

    public ArrayList<Course> GetAllCourse() throws IOException {
        return new CourseJSONFileProcessor().readAllCourseJSON();
    }

    public ArrayList<Object> SearchVideo(String videoID, int num) throws ClassNotFoundException {
        return new VideoJSONFileProcessor().readJSON(videoID, num);
    }


}
