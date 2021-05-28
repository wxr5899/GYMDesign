package com.SEGroup80.Controller;

import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Service.ModifyFileService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import java.io.IOException;
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
        balance = trainer.getBalance();
        BalanceLabel.setText("Account Balance: " + balance);
    }

    @FXML
    public void Charge() throws IOException {
        balance += Double.parseDouble(chargeNumber.getText());
        trainer.setBalance(balance);
        new ModifyFileService().modifyUserFile(trainer);
    }

    @FXML
    public void CheckOut() {
        
    }

}
