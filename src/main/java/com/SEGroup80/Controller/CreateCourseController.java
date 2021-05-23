package com.SEGroup80.Controller;

import com.SEGroup80.Pojo.CoursePojo.Course;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateCourseController implements Initializable {


    @FXML
    private TextField CoachID;

    @FXML
    private Button createCourse;

    @FXML
    public Course createCourseButton() {

        Course course = null;

        course = new Course(null, "hit", "Record", null);



        return course;
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
