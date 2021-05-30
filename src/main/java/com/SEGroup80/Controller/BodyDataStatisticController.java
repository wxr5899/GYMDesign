package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.BasicPojo.Body;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Tool.PageTransTool;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BodyDataStatisticController implements Initializable {

    private Trainer trainer;

    private ArrayList<Body> bodyArrayList = null;

    private int StartMONTH = 1;

    private int MONTH;

    private int EndMONTH = 12;

    private LineChart weightLineChart, heightLineChart, hipLineChart, waistLineChart;

    private Parent root;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private AnchorPane chartLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        trainer = TemBean.getTrainer();


        bodyArrayList = trainer.getBodyRecord();

        if (bodyArrayList != null){
            if (!bodyArrayList.isEmpty()){


                NumberAxis monthAxis1 = new NumberAxis(StartMONTH, EndMONTH, 1);
                NumberAxis monthAxis2 = new NumberAxis(StartMONTH, EndMONTH, 1);
                NumberAxis monthAxis3 = new NumberAxis(StartMONTH, EndMONTH, 1);
                NumberAxis monthAxis4 = new NumberAxis(StartMONTH, EndMONTH, 1);
                NumberAxis weightAxis = new NumberAxis(30 , 90, 1);
                NumberAxis heightAxis = new NumberAxis(0 , 3, 0.1);
                NumberAxis hipAxis = new NumberAxis(0 , 1.5, 0.01);
                NumberAxis waistAxis = new NumberAxis(0 , 1.5, 0.01);

                weightLineChart = new LineChart(monthAxis1, weightAxis);
                weightLineChart.setPrefHeight(260);
                weightLineChart.setPrefWidth(500);
                weightLineChart.setLayoutX(0);
                weightLineChart.setLayoutY(0);
                weightLineChart.setEffect(new DropShadow());

                heightLineChart = new LineChart(monthAxis2, heightAxis);
                heightLineChart.setPrefHeight(260);
                heightLineChart.setPrefWidth(500);
                heightLineChart.setLayoutX(500);
                heightLineChart.setLayoutY(0);
                heightLineChart.setEffect(new DropShadow());

                hipLineChart = new LineChart(monthAxis3, hipAxis);
                hipLineChart.setPrefHeight(260);
                hipLineChart.setPrefWidth(500);
                hipLineChart.setLayoutX(0);
                hipLineChart.setLayoutY(260);
                hipLineChart.setEffect(new DropShadow());

                waistLineChart = new LineChart(monthAxis4, waistAxis);
                waistLineChart.setPrefHeight(260);
                waistLineChart.setPrefWidth(500);
                waistLineChart.setLayoutX(500);
                waistLineChart.setLayoutY(260);
                waistLineChart.setEffect(new DropShadow());


                XYChart.Series weightSeries = new XYChart.Series();
                XYChart.Series heightSeries = new XYChart.Series();
                XYChart.Series hipSeries = new XYChart.Series();
                XYChart.Series waistSeries = new XYChart.Series();
                weightSeries.setName("Variation of Weight.");
                heightSeries.setName("Variation of Height.");
                hipSeries.setName("Variation of Hip.");
                waistSeries.setName("Variation of Waist.");

                for (Body body : bodyArrayList){


                    System.out.println(body.getTimePoint());
                    MONTH = Integer.parseInt(body.getTimePoint().substring(5,7));
                    System.out.println(MONTH);
                    weightSeries.getData().add(new XYChart.Data<>(MONTH, body.getWeight()));
                    heightSeries.getData().add(new XYChart.Data<>(MONTH, body.getHeight()));
                    hipSeries.getData().add(new XYChart.Data<>(MONTH, body.getHip()));
                    waistSeries.getData().add(new XYChart.Data<>(MONTH, body.getWaist()));
                }
                weightLineChart.getData().add(weightSeries);
                heightLineChart.getData().add(heightSeries);
                hipLineChart.getData().add(hipSeries);
                waistLineChart.getData().add(waistSeries);

                chartLayout.getChildren().addAll(weightLineChart, heightLineChart, hipLineChart, waistLineChart);

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("There is no body data to show, please upload first!");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("There is no body data to show, please upload first!");
            alert.show();
        }

    }

    public void backHome() throws IOException {
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }
}
