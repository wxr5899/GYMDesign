package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Service.SearchService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CoachInfoController implements Initializable {

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private Button BackHome, BookButton;

    @FXML
    private Label NameLabel, AgeLabel, SexLabel, EmailLabel, PhoneLabel;

    @FXML
    private ImageView CoachPhoto;

    @FXML
    private Text Description;

    @FXML
    private Label course1Name, course2Name, course3Name, book1, book2, book3;

    @FXML
    private ImageView leftSwitchRec, rightSwitchRec, leftSwitchLiv, rightSwitchLiv;

    private String gender;

    private Parent root = null;

    private final int CourseNum = 3;

    private int courseIndex = 0;

    private int bookIndex = 0;

    private ArrayList<Course> courseArrayList = null;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        Coach coach = TemBean.getCoach();

        NameLabel.setText(coach.getName());
        AgeLabel.setText(String.valueOf(coach.getAge()));
        if (coach.isSex()) {
            gender = "Sir";
        }
        gender = "Lady";
        SexLabel.setText(gender);
        EmailLabel.setText(coach.getMail());
        PhoneLabel.setText(coach.getPhoneNumber());
        Description.setText(coach.getDescription());

        Image image = new Image("com/SEGroup80/Image/CoachImage/Coach1.png");
        CoachPhoto.setImage(image);

        ArrayList<String> courseIDArrayList = coach.getCourseList();
        ;
        SearchService searchService = new SearchService();
        try {
            courseArrayList = searchService.GetAllCourse();
        } catch (IOException e) {
            e.printStackTrace();
        }


        course1Name.setText(courseArrayList.get(0).getCourseName());
        course2Name.setText(courseArrayList.get(1).getCourseName());
        course3Name.setText(courseArrayList.get(2).getCourseName());


        rightSwitchRec.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (courseIndex < Math.ceil(((double)courseArrayList.size() / 3.0))){
                    courseIndex += 1;
                    course1Name.setText(courseArrayList.get(courseIndex * 3).getCourseName());
                    course2Name.setText(courseArrayList.get(courseIndex * 3 + 1).getCourseName());
                    course3Name.setText(courseArrayList.get(courseIndex * 3 + 2).getCourseName());
                }
            }
        });

        leftSwitchRec.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (courseIndex > 0){
                    courseIndex -= 1;
                    course1Name.setText(courseArrayList.get(courseIndex * 3).getCourseName());
                    course2Name.setText(courseArrayList.get(courseIndex * 3 + 1).getCourseName());
                    course3Name.setText(courseArrayList.get(courseIndex * 3 + 2).getCourseName());
                }
            }
        });

        System.out.println(courseArrayList.size());


        BackHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {


                try {
                    root = App.loadFXML("HomeInterface");
                    new PageTransTool().TransToAnotherPage(rootLayout, root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        BookButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    root = App.loadFXML("BookInterface");
                    new PageTransTool().TransToAnotherPage(rootLayout, root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
