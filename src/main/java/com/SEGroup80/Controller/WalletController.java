package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Service.ModifyFileService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WalletController implements Initializable {

    private Trainer trainer;

    private double balance;

    private Parent root;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private TextField chargeNumber;

    @FXML
    private Label BalanceLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        trainer = TemBean.getTrainer();
        balance = trainer.getBalance();
        BalanceLabel.setText("Account Balance: " + balance);

        final ToggleGroup group = new ToggleGroup();

        RadioButton choice1 = new RadioButton("1 MONTHS    30$");
        choice1.setToggleGroup(group);
        choice1.setUserData(30);
        choice1.setLayoutX(200);
        choice1.setLayoutY(270);
        choice1.setStyle("-fx-font: Times New Roman");
        choice1.setStyle("-fx-font-size: 15px");

        RadioButton choice2 = new RadioButton("3 MONTHS    78$");
        choice2.setToggleGroup(group);
        choice2.setUserData(78);
        choice2.setLayoutX(370);
        choice2.setLayoutY(270);
        choice2.setStyle("-fx-font: Times New Roman");
        choice2.setStyle("-fx-font-size: 15px");

        RadioButton choice3 = new RadioButton("6 MONTHS    148$");
        choice3.setToggleGroup(group);
        choice3.setUserData(148);
        choice3.setLayoutX(200);
        choice3.setLayoutY(320);
        choice3.setStyle("-fx-font: Times New Roman");
        choice3.setStyle("-fx-font-size: 15px");

        RadioButton choice4 = new RadioButton("12 MONTHS   298$");
        choice4.setToggleGroup(group);
        choice4.setUserData(298);
        choice4.setLayoutX(370);
        choice4.setLayoutY(320);
        choice4.setStyle("-fx-font: Times New Roman");
        choice4.setStyle("-fx-font-size: 15px");


        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldToggle, Toggle newToggle) {
                if (group.getSelectedToggle() != null) {
                    System.out.println(group.getSelectedToggle()
                            .getUserData());
                }
            }
        });

        rootLayout.getChildren().addAll(choice1, choice2, choice3, choice4);



    }

    @FXML
    public void Charge() throws IOException {
        balance += Double.parseDouble(chargeNumber.getText());
        trainer.setBalance(balance);
        new ModifyFileService().modifyUserFile(trainer);
    }

    @FXML
    public void backHome() throws IOException {
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

    @FXML
    public void CheckOut() {

        
    }

}
