package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.SearchService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private TextField userID;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton, enrollButton;

    @FXML
    private ImageView closeTag;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private Label warnLabel;

    private Parent root = null;

    private Scene scene;


    public void LoadLoginInterface(Stage stage) throws IOException {

        root = App.loadFXML("HomeInterface");
        scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        System.out.println(stage);
        stage.show();

        root.setOnMousePressed((MouseEvent event) -> {
            event.consume();
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            event.consume();
            stage.setX(event.getScreenX() - xOffset);


            if (event.getScreenY() - yOffset < 0) {
                stage.setY(0);
            } else {
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void handleLogin(MouseEvent mouseEvent) throws IOException {
        /*
        测试数据：
        账号：M18335735899
        密码：123456
         */


        String uID = userID.getText();
        String uPwd = password.getText();

        if (Objects.equals(uID, "") || Objects.equals(uPwd, "")) {
            warnLabel.setText("Your name or password is empty!");
        } else {
            User user = (User) new SearchService().SearchUser(uID, 1).get(0);

            if (user == null){
                warnLabel.setText("This user does not exist!");
            } else {
                if (uPwd.equals(user.getPassword())) {
                    System.out.println("login success!");

                    root = App.loadFXML("HomeInterface");
                    Stage stage = (Stage)rootLayout.getScene().getWindow();
                    stage.close();
                    scene = rootLayout.getScene();
                    scene.setRoot(root);
                    stage.show();

                } else {
                    warnLabel.setText("Your Password is not correct!");
                }
            }
        }

    }

    @FXML
    public void handleEroll (){

        scene = rootLayout.getScene();

        try {
            root = App.loadFXML("videoPlay"); //progressBAR
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage)rootLayout.getScene().getWindow();
        stage.close();
        scene.setRoot(root);
        stage.show();
    }

    @FXML
    public void closeLoginInterface(){
        Stage stage = (Stage)rootLayout.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
}
