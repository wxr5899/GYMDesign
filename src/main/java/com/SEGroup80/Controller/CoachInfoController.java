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

    @FXML
    private ImageView course1Image, course2Image, course3Image;

    private String gender;

    private Parent root = null;

    private Coach coach;

    private final int CourseNum = 3;

    private int courseIndex = 0;

    private int bookIndex = 0;

    private ArrayList<Course> courseArrayList = new ArrayList<>();

    private Course course1, course2, course3;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        coach = TemBean.getCoach();

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

        CoachPhoto.setImage(new Image("com/SEGroup80/Image/CoachImage/Coach1.png"));

        course1Image.setImage(new Image("com/SEGroup80/Image/CourseImage/cover1.jpg"));
        course1Image.setPreserveRatio(false);
        course2Image.setImage(new Image("com/SEGroup80/Image/CourseImage/cover1.jpg"));
        course2Image.setPreserveRatio(false);
        course3Image.setImage(new Image("com/SEGroup80/Image/CourseImage/cover1.jpg"));
        course3Image.setPreserveRatio(false);


        ArrayList<String> courseIDArrayList = coach.getCourseList();

        SearchService searchService = new SearchService();

        for(String ID : courseIDArrayList) {
            Course course = searchService.SearchCourse(ID);
            if (course != null){
                courseArrayList.add(searchService.SearchCourse(ID));
            }
        }

        if (courseArrayList.size() > 0) {
            course1 = courseArrayList.get(0);
            course1Name.setText(course1.getCourseName());
        } else {
            course1 = null;
            course1Name.setText("empty");
        }

        if (courseArrayList.size() > 1) {
            course2 = courseArrayList.get(1);
            course2Name.setText(course2.getCourseName());
        } else {
            course2 = null;
            course1Name.setText("empty");
        }

        if (courseArrayList.size() > 2) {
            course3 = courseArrayList.get(2);
            course3Name.setText(course3.getCourseName());
        } else {
            course3 = null;
            course3Name.setText("empty");
        }



        rightSwitchRec.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (courseIndex < Math.ceil(((double)courseArrayList.size() / 3.0)) - 1){
                    courseIndex += 1;

                    if (courseIndex * 3 >= courseIDArrayList.size()) {
                        course1Name.setText("empty");
                        course1 = null;
                    } else {
                        course1 = courseArrayList.get(courseIndex * 3);
                        course1Name.setText(course1.getCourseName());
                    }

                    if (courseIndex * 3 + 1 >= courseIDArrayList.size()) {
                        course2Name.setText("empty");
                        course2 = null;
                    } else {
                        course2 = courseArrayList.get(courseIndex * 3 + 1);
                        course2Name.setText(course2.getCourseName());
                    }

                    if (courseIndex * 3 + 2 >= courseIDArrayList.size()) {
                        course3Name.setText("empty");
                        course3 = null;
                    } else {
                        course3 = courseArrayList.get(courseIndex * 3 + 2);
                        course3Name.setText(course3.getCourseName());
                    }
                }
            }
        });

        leftSwitchRec.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (courseIndex > 0){
                    courseIndex -= 1;
                    course1 = courseArrayList.get(courseIndex * 3);
                    course1Name.setText(course1.getCourseName());

                    course2 = courseArrayList.get(courseIndex * 3 + 1);
                    course2Name.setText(course2.getCourseName());

                    course3 = courseArrayList.get(courseIndex * 3 + 2);
                    course3Name.setText(course3.getCourseName());
                }
            }
        });

        course1Image.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (course1 != null){
                    TemBean.setCourse(course1);
                    try {
                        root = App.loadFXML("CourseInterface");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new PageTransTool().TransToAnotherPage(rootLayout, root);
                }
            }
        });

        course2Image.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (course2 != null){
                    TemBean.setCourse(course2);
                    try {
                        root = App.loadFXML("CourseInterface");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new PageTransTool().TransToAnotherPage(rootLayout, root);
                }
            }
        });

        course3Image.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (course3 != null){
                    TemBean.setCourse(course3);
                    try {
                        root = App.loadFXML("CourseInterface");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new PageTransTool().TransToAnotherPage(rootLayout, root);
                }
            }
        });


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

                TemBean.setCoach(coach);

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
