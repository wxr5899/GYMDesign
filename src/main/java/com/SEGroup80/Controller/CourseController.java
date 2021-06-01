package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.CoursePojo.RecordCourse;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.SearchService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    private Parent root;

    private RecordCourse course;

    private Video video;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private ImageView coverImage;

    @FXML
    private Label courseDsp, courseName, coachName;

    @FXML
    private VBox videoBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        course = (RecordCourse) TemBean.getCourse();
        SearchService searchService = new SearchService();

        courseDsp.setText(course.getIntroduction());
        courseName.setText(course.getCourseName());
        coverImage.setImage(new Image(course.getPhotoURL()));

        ArrayList<String> authorID = course.getCoachList();
        String authorNames = "";

        for (String ID : authorID) {
            authorNames += ((User) searchService.SearchUser(ID, 1).get(0)).getName() + "," + " ";
        }
        coachName.setText("Coach: " + authorNames);
        ArrayList<String> videoID = course.getVideoList();

        if (!videoID.isEmpty()){
            for (String ID : videoID) {
                try {
                    video = (Video) searchService.SearchVideo(ID, 1).get(0);

                    AnchorPane anchorPane = new AnchorPane();
                    anchorPane.setPrefHeight(50);
                    anchorPane.setPrefWidth(600);

                    Label videolabel = new Label(" " + video.getTitle());
                    videolabel.setStyle("-fx-font: Times New Roman");
                    videolabel.setStyle("-fx-font-size: 15px");
                    videolabel.setLayoutX(10);
                    videolabel.setPrefWidth(600);
                    videolabel.setPrefHeight(30);
                    videolabel.setLayoutY(10);

                    videolabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            TemBean.setVideo(video);
                            try {
                                root = App.loadFXML("VideoPlay");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            new PageTransTool().TransToAnotherPage(rootLayout, root);
                        }
                    });

                    anchorPane.getChildren().add(videolabel);

                    videoBox.getChildren().add(anchorPane);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    @FXML
    public void backHome() throws IOException {
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }
}
