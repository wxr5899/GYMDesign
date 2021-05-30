package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.CoursePojo.RecordCourse;
import com.SEGroup80.Service.EnrollService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpLoadCourseController implements Initializable {

    @FXML
    TextField CourseName, Author, video, Introduction, price, photoUrl;

    @FXML
    AnchorPane rootLayout;

    private Course course;

    Parent root;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    public void backHome() throws IOException {
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }



    public void upload(){

        ArrayList<String> producerList = new ArrayList<>();
        ArrayList<String> videoList = new ArrayList<>();
        ArrayList<String> likeList = new ArrayList<>();
        ArrayList<String> collectList = new ArrayList<>();
        ArrayList<String> trainerList = new ArrayList<>();

        String[] author = Author.getText().split("-");

        for (String ID : author) {
            producerList.add(ID);
        }

        String Name = CourseName.getText();

        String description = Introduction.getText();

        double priceNum = Double.parseDouble(price.getText());

        String url = photoUrl.getText();



        String[] videoID = video.getText().split("-");

        for (String ID : videoID) {
            videoList.add(ID);
        }

        course = new RecordCourse(producerList, Name, "Record", trainerList, videoList, description, priceNum);

        course.setPhotoURL(url);

        EnrollService enrollService = new EnrollService();
        enrollService.courseEnroll(course);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Upload success");
        alert.show();
    }
}
