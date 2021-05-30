package com.SEGroup80.Controller;

import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class BookHistoryController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (TemBean.getIdentity() == "Trainer"){
            Trainer trainer = TemBean.getTrainer();

        } else {
            Coach coach = TemBean.getCoach();
        }



    }
}
