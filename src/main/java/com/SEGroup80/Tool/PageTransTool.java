package com.SEGroup80.Tool;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageTransTool {


    public void TransToAnotherPage (Node node, Parent root){
        Scene scene = node.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        scene.setRoot(root);
        stage.show();
    }


    public void closePage() {

    }




}
