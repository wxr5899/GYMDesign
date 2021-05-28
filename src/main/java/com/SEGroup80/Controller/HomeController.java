package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.SearchService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    private final int popVideoNum = 4;
    private final int popVideoLikeLabelX = 14;
    private final int popVideoLikeLabelY = 149;
    private final int popVideoCollectLabelX = 164;
    private final int popVideoCollectLabelY = 149;
    private final int popCourseNum = 6;
    private final int popCoachNum = 4;

    /*
        Some urls of resource in the HomeInterface:
     */
    private final String likeIconUrl = "com/SEGroup80/Image/Icon/likeIcon.png";
    private final String collectIconUrl = "com/SEGroup80/Image/Icon/collectIcon.png";
    private final String playIconUrl = "com/SEGroup80/Image/Icon/playIcon.png";
    /*
        Styles of the four main interface Label
     */
    private final String style1 = "-fx-background-color: #1d1626;";
    private final String style2 = "-fx-background-color: black;";
    private Parent root = null;
    private Scene scene;
    private User user;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private Label coursePaneLabel, coachPaneLabel, accountPaneLabel, homePaneLabel;

    @FXML
    private Pane coursePane, coachPane, accountPane, homePane;

    @FXML
    private ImageView closeIcon;

    /*
        Nodes in Home Pane
     */
    @FXML
    private ScrollBar homeScrollBar, coachScrollBar;

    @FXML
    private VBox homeVBox;

    @FXML
    private AnchorPane homeADPane;

    @FXML
    private ImageView homeADImage;

    /*
        Nodes in the "Popular Video Display Box" in Home Pane;
     */

    @FXML
    private HBox popularVideosHBox;

    @FXML
    private VBox videoVBoxLeft;

    @FXML
    private VBox videoVBoxRight;

    @FXML
    private VBox coachVBox;


    /*
        Nodes in Account Pane
     */
    @FXML
    private Label PrName, PrAge, PrIdentity, PrGender, PrMail, PrPhone;

    @FXML
    private VBox friendVBox;

    @FXML
    private ImageView VIPIcon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String identity = TemBean.getIdentity();

        if ("Coach".equals(identity)) {
            user = TemBean.getCoach();
        } else if ("Trainer".equals(identity)) {
            user = TemBean.getTrainer();
        } else {
            user = TemBean.getManager();
        }


        ArrayList<Video> videoArrayList = new ArrayList<Video>();

        SearchService searchService = new SearchService();

        ArrayList<Object> objectArrayList = null;
        try {
            objectArrayList = searchService.SearchVideo(null, popVideoNum);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < popVideoNum; i++) {
            Video video = (Video) objectArrayList.get(i);
            videoArrayList.add(video);
        }

        homeVBox.setPrefWidth(760);
        homeVBox.setPrefHeight(2000);

        for (int i = 0; i < popVideoNum; i++) {

            /*
                Get the information of a video
             */
            Video video = videoArrayList.get(i);
            String videoName = video.getTitle();
            String videoAuthorID = video.getProducerList().get(0);



            User coach = (User) new SearchService().SearchUser(videoAuthorID, 1).get(0);
            String videoAuthorName = coach.getName();
            System.out.println(videoAuthorName);
            String videoFileUrl = video.getVideoURL();
            String videoCoverUrl = "com/SEGroup80/Image/CourseImage/cover1.jpg";
            int likeNum = video.getLikeList().size();
            int collectNum = video.getCollectionList().size();

            /*
                AnchorPane of a pop video
             */
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefWidth(380);
            anchorPane.setPrefHeight(200);

            /*
                Cover of a pop video
             */
            Image cover = new Image(videoCoverUrl);
            ImageView imageViewCover = new ImageView(cover);
            imageViewCover.setFitWidth(230);
            imageViewCover.setFitHeight(150);
            imageViewCover.setLayoutX(14);
            imageViewCover.setLayoutY(25);
            imageViewCover.setPreserveRatio(false);
            imageViewCover.setVisible(true);
            imageViewCover.setEffect(new DropShadow());

            /*
                Icon of a pop video cover
             */

            Image playIconImage = new Image(playIconUrl);
            ImageView playIconView = new ImageView(playIconImage);

            playIconView.setImage(playIconImage);

            playIconView.setFitWidth(70);
            playIconView.setFitHeight(70);
            playIconView.setLayoutX(94);
            playIconView.setLayoutY(65);



            Label videoNameLabel = new Label(videoName);
            videoNameLabel.setLayoutX(260);
            videoNameLabel.setLayoutY(70);
            videoNameLabel.setStyle("-fx-font: Times New Roman");
            videoNameLabel.setStyle("-fx-font-size: 14px");
            videoNameLabel.setPrefWidth(100);

            Label videoAuthorLabel = new Label(videoAuthorName);
            videoAuthorLabel.setLayoutX(260);
            videoAuthorLabel.setLayoutY(90);
            videoAuthorLabel.setStyle("-fx-font: Times New Roman");
            videoAuthorLabel.setStyle("-fx-font-size: 14px");
            videoAuthorLabel.setPrefWidth(100);



            /*
                Like Label and Icon in a video cover
             */
            Label likeLabel = new Label("" + video.getLikeList().size());
            likeLabel.setPrefWidth(80);
            likeLabel.setPrefHeight(25);
            likeLabel.setStyle("-fx-font: Times New Roman");
            likeLabel.setStyle("-fx-font-size: 14px");
            likeLabel.setLayoutX(popVideoLikeLabelX);
            likeLabel.setLayoutY(popVideoLikeLabelY);

            /*
                like Icon
             */
            Image likeImage = new Image(likeIconUrl);
            ImageView likeIcon = new ImageView(likeImage);
            likeIcon.setImage(likeImage);
            likeIcon.setFitWidth(25);
            likeIcon.setFitHeight(25);
            likeLabel.setGraphic(likeIcon);


            Label collectLabel = new Label("" + video.getCollectionList().size());
            collectLabel.setPrefWidth(80);
            collectLabel.setPrefHeight(25);
            collectLabel.setStyle("-fx-font: Times New Roman");
            collectLabel.setStyle("-fx-font-size: 14px");



            Image collectImage = new Image(collectIconUrl);
            ImageView collectIcon = new ImageView(collectImage);
            collectIcon.setImage(collectImage);
            collectIcon.setFitWidth(25);
            collectIcon.setFitHeight(25);
            collectLabel.setGraphic(collectIcon);
            collectLabel.setLayoutX(popVideoCollectLabelX);
            collectLabel.setLayoutY(popVideoCollectLabelY);

            collectLabel.setAlignment(Pos.CENTER);
            likeLabel.setAlignment(Pos.CENTER);



            /*
                Hide a button on the imageView control to add event listener.
             */
            Button playButton =  new Button();
            playButton.setStyle("-fx-background-color:transparent");

            playButton.setPrefWidth(70);
            playButton.setPrefHeight(70);
            playButton.setLayoutX(94);
            playButton.setLayoutY(65);

            homeScrollBar.setVisibleAmount(50);


            homeScrollBar.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    homeVBox.setLayoutY(-newValue.doubleValue());
                }
            });

            playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    playIconView.setStyle("-fx-opacity: 0.4");
                }
            });

            playButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    playIconView.setStyle("-fx-opacity: 1");
                }
            });

            playButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        TemBean.setVideo(video);
                        scene = rootLayout.getScene();
                        root = App.loadFXML("VideoPlay");
                        Stage stage = (Stage)rootLayout.getScene().getWindow();
                        stage.close();
                        scene.setRoot(root);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


            /*
                Add the Nodes to the AnchorPane
             */
            anchorPane.getChildren().addAll(videoNameLabel, videoAuthorLabel, imageViewCover, playIconView, likeLabel, collectLabel, likeIcon, collectIcon, playButton);

            /*
                If the order number of the video is odd then put it into the left VBox;
                else put it into the right VBox;
             */
            if (i % 2 == 0) {
                videoVBoxLeft.getChildren().add(anchorPane);
            } else {
                videoVBoxRight.getChildren().add(anchorPane);
            }

        }

        coachScrollBar.setBlockIncrement(100);

        ArrayList<Object> coachList = new SearchService().SearchUser("C", popCoachNum);

        for (int i = 0; i < popCoachNum; i++) {

            Coach coach = (Coach) coachList.get(i);


            HBox hBox = new HBox();
            hBox.setPrefWidth(760);
            hBox.setPrefHeight(250);

            AnchorPane leftAnchorPane = new AnchorPane();
            leftAnchorPane.setPrefWidth(380);
            leftAnchorPane.setPrefHeight(200);

            AnchorPane rightAnchorPane = new AnchorPane();
            rightAnchorPane.setPrefWidth(380);
            rightAnchorPane.setPrefHeight(200);

            String coachImageUrl = "com/SEGroup80/Image/CoachImage/Coach1.png";
            Image coverImage =  new Image(coachImageUrl);
            ImageView coverImageView = new ImageView(coverImage);
            coverImageView.setFitWidth(100);
            coverImageView.setFitHeight(180);
            coverImageView.setLayoutX(40);
            coverImageView.setLayoutY(20);
            coverImageView.setPreserveRatio(true);
            coverImageView.setEffect(new DropShadow());
            coverImageView.setEffect(new DropShadow());
            leftAnchorPane.getChildren().add(coverImageView);

            Label coachName = new Label(coach.getName());
            coachName.setPrefHeight(20);
            coachName.setPrefWidth(100);
            coachName.setLayoutX(155);
            coachName.setLayoutY(40);
            coachName.setStyle("-fx-font: Times New Roman");
            coachName.setStyle("-fx-font-size: 14px");

            leftAnchorPane.getChildren().add(coachName);

            Label coachAge = new Label("Age:" + coach.getAge());
            coachAge.setPrefHeight(20);
            coachAge.setPrefWidth(100);
            coachAge.setLayoutX(155);
            coachAge.setLayoutY(70);
            coachAge.setStyle("-fx-font: Times New Roman");
            coachAge.setStyle("-fx-font-size: 14px");

            leftAnchorPane.getChildren().add(coachAge);

            String sex = "Lady";
            if (coach.isSex()){
                sex = "Sir";
            }
            Label coachSex = new Label(sex);
            coachSex.setPrefHeight(20);
            coachSex.setPrefWidth(100);
            coachSex.setLayoutX(155);
            coachSex.setLayoutY(100);
            coachSex.setStyle("-fx-font: Times New Roman");
            coachSex.setStyle("-fx-font-size: 14px");

            leftAnchorPane.getChildren().add(coachSex);

            Button detailButton = new Button();
            detailButton.setStyle("-fx-background-color:transparent");
            detailButton.setPrefHeight(180);
            detailButton.setPrefWidth(100);
            detailButton.setLayoutX(40);
            detailButton.setLayoutY(20);


            detailButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TemBean.setCoach(coach);
                    try {
                        root = App.loadFXML("CoachInfo");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new PageTransTool().TransToAnotherPage(rootLayout, root);
                }
            });

            leftAnchorPane.getChildren().add(detailButton);




            hBox.getChildren().addAll(leftAnchorPane, rightAnchorPane);
            coachVBox.getChildren().add(hBox);


            coachScrollBar.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    coachVBox.setLayoutY(-newValue.doubleValue());
                }
            });
        }

        if ("Trainer".equals(user.getIdentity())){
            Trainer trainer = (Trainer) user;
            if (trainer.getMemberShip().getMemberShip()){
                VIPIcon.setOpacity(0.8);
            }
        }
        PrAge.setText("Age: " + user.getAge());
        PrIdentity.setText("Identity: " + TemBean.getIdentity());
        String gender = "Lady";
        if (user.isSex()){
            gender = "Sir";
        }
        PrGender.setText(gender);
        PrMail.setText("Mail:" + user.getMail());
        PrPhone.setText("Call:" + user.getPhoneNumber());
        PrName.setText(user.getName());

        if (identity.equals("Trainer")) {
            Trainer trainer = (Trainer) user;
            if (!trainer.getFriendList().isEmpty()){
                for (String friendID : trainer.getFriendList()){
                    String friendName = ((User) searchService.SearchUser(friendID, 1).get(0)).getName();
                    Label friendNameLabel = new Label(friendName);
                    friendNameLabel.setPrefWidth(150);
                    friendNameLabel.setPrefHeight(30);
                    friendNameLabel.setLayoutX(90);
                    friendNameLabel.setPadding(new Insets(10 , 10, 10, 10));
                    friendNameLabel.setStyle("-fx-font: Times New Roman");
                    friendNameLabel.setStyle("-fx-font-size: 14px");
                    friendVBox.getChildren().add(friendNameLabel);
                }
            }
        }



    }

    @FXML
    public void switchToCoursePane(){
        switchPane(false, false, false, true);
        coursePaneLabel.setStyle(style1);
        coachPaneLabel.setStyle(style2);
        accountPaneLabel.setStyle(style2);
        homePaneLabel.setStyle(style2);
    }

    @FXML
    public void switchToCoachPane(){
        switchPane(true, false, false, false);
        coursePaneLabel.setStyle(style2);
        coachPaneLabel.setStyle(style1);
        accountPaneLabel.setStyle(style2);
        homePaneLabel.setStyle(style2);
    }

    @FXML
    public void switchToAccountPane(){
        switchPane(false, true, false, false);
        coursePaneLabel.setStyle(style2);
        coachPaneLabel.setStyle(style2);
        accountPaneLabel.setStyle(style1);
        homePaneLabel.setStyle(style2);
    }

    @FXML
    public void switchToHomePane(){
        switchPane(false, false, true, false);
        coursePaneLabel.setStyle(style2);
        coachPaneLabel.setStyle(style2);
        accountPaneLabel.setStyle(style2);
        homePaneLabel.setStyle(style1);
    }

    @FXML
    public void JumpToWallet() throws IOException {
        root = App.loadFXML("WalletInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

    @FXML
    public void JumpToHistory() throws IOException {
        root = App.loadFXML("HistoryInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

    @FXML
    public void JumpToBodyData() throws IOException {
        root = App.loadFXML("BodyInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

    @FXML
    public void closeHomeInterface(){
        Stage stage = (Stage)rootLayout.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    /*
        The function for switch the four main interface in the HomeInterface
     */
    public void switchPane(Boolean b1, Boolean b2, Boolean b3, Boolean b4) {
        coachPane.setVisible(b1);
        accountPane.setVisible(b2);
        homePane.setVisible(b3);
        coursePane.setVisible(b4);
    }

}
