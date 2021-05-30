package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.BasicPojo.Book;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.SearchService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookHistoryController implements Initializable {
    @FXML
    private AnchorPane rootLayout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        VBox bookVbox = new VBox();

        ArrayList<String> timePeriodList = new ArrayList<>();

        timePeriodList.add("08:00-09:00");
        timePeriodList.add("09:00-10:00");
        timePeriodList.add("10:00-11:00");
        timePeriodList.add("11:00-12:00");

        timePeriodList.add("14:00-15:00");
        timePeriodList.add("15:00-16:00");
        timePeriodList.add("16:00-17:00");

        timePeriodList.add("20:00-21:00");
        timePeriodList.add("21:00-22:00");



        if (TemBean.getIdentity() == "Trainer"){
            Trainer trainer = TemBean.getTrainer();

            if (trainer.getBookList() == null){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("You haven't book a Coach!");
                alert.show();
            } else {

                for (Book book : trainer.getBookList()){
                    AnchorPane anchorPane = new AnchorPane();
                    anchorPane.setPrefWidth(600);
                    anchorPane.setPrefHeight(50);

                    User user = (User) new SearchService().SearchUser(book.getCoachID(), 1).get(0);

                    Label trainerName = new Label(trainer.getName());
                    trainerName.setLayoutX(10);
                    trainerName.setLayoutY(10);
                    trainerName.setStyle("-fx-font: Times New Roman");
                    trainerName.setStyle("-fx-font-size: 14px");
                    trainerName.setPrefWidth(190);
                    trainerName.setPrefHeight(30);

                    Label coachName = new Label(user.getName());
                    coachName.setLayoutX(210);
                    coachName.setLayoutY(10);
                    coachName.setStyle("-fx-font: Times New Roman");
                    coachName.setStyle("-fx-font-size: 14px");
                    coachName.setPrefWidth(190);
                    coachName.setPrefHeight(30);

                    for (int i = 0; i < book.getTimeTable().size(); i++) {
                        String timePeriod = "";

                        if (book.getTimeTable().get(i) == 1){
                            timePeriod = timePeriodList.get(i);
                            Label timePoint = new Label(book.getDate() + "  " + timePeriod);
                            timePoint.setLayoutX(410);
                            timePoint.setLayoutY(10);
                            timePoint.setStyle("-fx-font: Times New Roman");
                            timePoint.setStyle("-fx-font-size: 14px");
                            timePoint.setPrefWidth(190);
                            timePoint.setPrefHeight(30);
                            anchorPane.getChildren().addAll(trainerName, coachName, timePoint);
                            bookVbox.getChildren().add(anchorPane);
                        }

                    }

                }

            }

        } else {
            Coach coach = TemBean.getCoach();

            if (coach.getBookList() == null){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("You haven't book a Coach!");
                alert.show();
            } else {

                for (Book book : coach.getBookList()){
                    AnchorPane anchorPane = new AnchorPane();
                    anchorPane.setPrefWidth(600);
                    anchorPane.setPrefHeight(50);

                    User user = (User) new SearchService().SearchUser(book.getTrainerID(), 1).get(0);

                    Label trainerName = new Label(user.getName());
                    trainerName.setLayoutX(10);
                    trainerName.setLayoutY(10);
                    trainerName.setStyle("-fx-font: Times New Roman");
                    trainerName.setStyle("-fx-font-size: 14px");
                    trainerName.setPrefWidth(190);
                    trainerName.setPrefHeight(30);

                    Label coachName = new Label(coach.getName());
                    coachName.setLayoutX(210);
                    coachName.setLayoutY(10);
                    coachName.setStyle("-fx-font: Times New Roman");
                    coachName.setStyle("-fx-font-size: 14px");
                    coachName.setPrefWidth(190);
                    coachName.setPrefHeight(30);

                    for (int i = 0; i < book.getTimeTable().size(); i++) {
                        String timePeriod = "";

                        if (book.getTimeTable().get(i) == 1){
                            timePeriod = timePeriodList.get(i);
                            Label timePoint = new Label(book.getDate() + "  " + timePeriod);
                            timePoint.setLayoutX(410);
                            timePoint.setLayoutY(10);
                            timePoint.setStyle("-fx-font: Times New Roman");
                            timePoint.setStyle("-fx-font-size: 14px");
                            timePoint.setPrefWidth(190);
                            timePoint.setPrefHeight(30);
                            anchorPane.getChildren().addAll(trainerName, coachName, timePoint);
                            bookVbox.getChildren().add(anchorPane);
                        }
                    }
                }
            }
        }

        bookVbox.setLayoutY(80);
        bookVbox.setLayoutX(0);
        bookVbox.setPrefWidth(600);
        bookVbox.setPrefHeight(320);

        rootLayout.getChildren().add(bookVbox);
    }

    public void backHome() throws IOException {
        Parent root;
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

}
