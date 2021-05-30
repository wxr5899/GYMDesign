package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.EnrollService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnrollController implements Initializable {

    @FXML
    private TextField userID, name, age, phone, mail, pwd, photo;

    @FXML
    private Button enroll;

    @FXML
    private ChoiceBox identityChoice, genderChoice;

    @FXML
    private AnchorPane rootLayout;

    private boolean sex;

    @FXML
    public void enroll() {
        User user = null;
        user = new User((String) identityChoice.getValue(), pwd.getText(), name.getText(), mail.getText(), phone.getText(), Integer.parseInt(age.getText()), sex);
        user.setPhotoURL(photo.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Enroll Success!");
        alert.show();
        EnrollService enrollService = new EnrollService();
        enrollService.userEnroll(user);
        return;
    }

    @FXML
    public void backLogin() throws IOException {
        Parent root = App.loadFXML("LoginInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderChoice.getItems().add("Male");
        genderChoice.getItems().add("Female");


        genderChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (genderChoice.getValue().equals("Male")){
                    sex = true;
                } else {
                    sex = false;
                }
            }
        });

        identityChoice.getItems().add("Trainer");
        identityChoice.getItems().add("Coach");
        identityChoice.getItems().add("Manager");

    }
}
