package com.SEGroup80.Controller;

import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class WalletController implements Initializable {


    private Trainer trainer;
    private double balance;

    @FXML
    Text chargeNumber;

    @FXML
    Label BalanceLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        trainer = TemBean.getTrainer();
        BalanceLabel.setText("Account Balance: " + trainer.getBalance());


    }

    @FXML
    public void Charge() {


    }

    @FXML
    public void CheckOut() {

    }

}
