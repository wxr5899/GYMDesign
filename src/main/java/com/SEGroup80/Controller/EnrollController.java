package com.SEGroup80.Controller;

import com.SEGroup80.Pojo.UserPojo.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EnrollController implements Initializable {

    @FXML
    private TextField userID, name, age, phoneNumber, email, password;

    @FXML
    private RadioButton male, female;

    @FXML
    private Button register, home;

    @FXML
    private ChoiceBox identity;

    private boolean sex;


    @FXML
    public User enroll() {
        User user = null;
        age.getText();

        if (male.isSelected()) {
            System.out.println("I;m here");
            sex = true;
        } else if (female.isSelected()) {
            sex = false;
        }

        user = new User((String) identity.getValue(), password.getText(), name.getText(), email.getText(), phoneNumber.getText(), Integer.parseInt(age.getText()), sex);
        System.out.println(user.toString());
        return user;
    }

    @FXML
    public void backHome() {


    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        identity.getItems().addAll("Trainer", "Coach");

    }
}
