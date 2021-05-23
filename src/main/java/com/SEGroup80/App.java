package com.SEGroup80;

import com.SEGroup80.Controller.LoginController;
import com.SEGroup80.Pojo.BasicPojo.*;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Manager;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Pojo.UserPojo.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {

        new LoginController().LoadLoginInterface(stage);


    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        System.out.println(App.class.getResource( "FXMLFile/" + fxml + ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "FXMLFile/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }



    public static void main(String[] args) {
        launch();
    }



}