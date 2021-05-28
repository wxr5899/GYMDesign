package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Service.ModifyFileService;
import com.SEGroup80.Tool.DateTool;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class WalletController implements Initializable {

    private Trainer trainer;

    private double balance;

    private Parent root;

    private double cost;

    private Label costLabel = new Label();

    private int dayNum = 0;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private TextField chargeNumber;

    @FXML
    private Label BalanceLabel;

    @FXML
    private ChoiceBox MemberShipChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        trainer = TemBean.getTrainer();
        balance = trainer.getBalance();
        BalanceLabel.setText("Account Balance: " + "$ " + balance);
        costLabel.setStyle("-fx-font: Times New Roman");
        costLabel.setStyle("-fx-font-size: 15px");
        costLabel.setLayoutX(85);
        costLabel.setLayoutY(280);
        costLabel.setPrefWidth(100);
        costLabel.setPrefHeight(30);

        MemberShipChoiceBox.getItems().addAll("", "1 MONTH 30$", "3 MONTH 78$", "6 MONTH 148$", "12 MONTHS 298$");

        MemberShipChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String choice = (String) observableValue.getValue();
                if ("1 MONTH 30$".equals(choice)){
                    cost = 30;
                    dayNum = 30;
                } else if ("3 MONTH 78$".equals(choice)){
                    cost = 78;
                    dayNum = 90;
                } else if ("6 MONTH 148$".equals(choice)){
                    cost = 148;
                    dayNum =180;
                } else if ("12 MONTHS 298$".equals(choice)){
                    cost = 298;
                    dayNum = 360;
                } else {
                    cost = 0;
                }
                costLabel.setText("Cost: $ " + cost);
            }
        });


        rootLayout.getChildren().addAll(costLabel);
    }

    @FXML
    public void Charge() throws IOException {
        balance += Double.parseDouble(chargeNumber.getText());
        BalanceLabel.setText("Account Balance: " + "$ " + balance);
        trainer.setBalance(balance);
        new ModifyFileService().modifyUserFile(trainer);
    }

    @FXML
    public void backHome() throws IOException {
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

    @FXML
    public void CheckOut() throws ParseException, IOException {

        if (cost > balance) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Your balance is not enough, please charge first!");
            alert.show();
            return;
        }


        if (cost != 0){
            trainer.getMemberShip().setMemberShip(true);
            DateTool dateTool = new DateTool();
            String endDateStr = trainer.getMemberShip().getEndDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date todayDate = new Date();
            Date endDate = simpleDateFormat.parse(endDateStr);
            if (todayDate.before(endDate)){
                endDate = dateTool.getBeforeOrAfterDate(endDate, dayNum);
            } else {
                endDate = dateTool.getBeforeOrAfterDate(todayDate, dayNum);
            }
            endDateStr = simpleDateFormat.format(endDate);
            trainer.getMemberShip().setEndDate(endDateStr);
            balance -= cost;
            new ModifyFileService().modifyUserFile(trainer);
            BalanceLabel.setText("Account Balance: " + "$ " + balance);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Open Success!");
            alert.show();
            return;
        }


    }

}
