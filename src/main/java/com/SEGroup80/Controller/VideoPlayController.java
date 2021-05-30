package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.ModifyFileService;
import com.SEGroup80.Tool.PageTransTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.ResourceBundle;

public class VideoPlayController implements Initializable {

    private MediaPlayer mediaPlayer;

    private boolean mouse = false;

    private String videoURL;

    private String videoName;

    private String videoDescription;

    private Scene scene;

    private Parent root = null;

    private Video video;

    private Trainer trainer;

    private int likeNum;

    private int collectNum;

    /*
        control buttons;
     */

    @FXML
    private Slider processSD, volumeSD;

    @FXML
    Label timeIndex;

    @FXML
    private ImageView playButtonIcon;

    @FXML
    private MediaView mediaView;

    @FXML
    private AnchorPane videoRootLayout, volumeAnchorPane;

    @FXML
    private Button volumeButton, playButton, backHomeButton;

    @FXML
    private Label likeNumLabel, collectNumLabel;

    @FXML
    private ImageView LikeImage, CollectImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        volumeAnchorPane.setVisible(false);

        volumeSD.setMin(0);
        volumeSD.setMax(1);
        volumeSD.setBlockIncrement(0.1);
        volumeSD.setValue(0.5);

        video = TemBean.getVideo();
        trainer = TemBean.getTrainer();

        if (video != null) {
            videoURL = video.getVideoURL();
            videoName = video.getTitle();
            videoDescription = video.getDescription();

            likeNum = video.getLikeList().size();
            likeNumLabel.setText("" + likeNum);
            collectNum = video.getCollectionList().size();
            collectNumLabel.setText("" + collectNum);

            if (video.getCollectionList().isEmpty()){
                CollectImage.setOpacity(0.5);
            } else {
                if (trainer != null){
                    for (String ID : video.getCollectionList()) {
                        if (ID.equals(trainer.getUserID())){
                            CollectImage.setOpacity(1);
                            break;
                        }
                    }
                }

            }

            if (video.getLikeList().isEmpty()){
                LikeImage.setOpacity(0.5);
            } else {
                if (trainer != null){
                    for (String ID : video.getLikeList()) {
                        if (ID.equals(trainer.getUserID())){
                            LikeImage.setOpacity(1);
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("There is a error during the data passing process");
            System.exit(0);
        }

        play(processSD, videoURL);

    }

    public void play(Slider slider, String videoURL) {

        File file = new File(videoURL);
        videoURL = file.toURI().toString();
        Media media = new Media(videoURL);
        initVideo(media);



        slider.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouse = true;
            }
        });

        slider.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouse = false;
                mediaPlayer.seek(Duration.seconds(slider.getValue()));
            }
        });

    }

    public void initVideo(Media media) {

        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }

        mediaPlayer = new MediaPlayer(media);

        mediaView.setMediaPlayer(mediaPlayer);

        mediaView.setPreserveRatio(false);


        mediaPlayer.setOnReady(new Runnable(){
            @Override
            public void run() {
                mediaPlayer.volumeProperty().bind(volumeSD.valueProperty());
                mediaPlayer.play();
                processSD.setValue(0);
                processSD.setMin(0);
                processSD.setMax(mediaPlayer.getTotalDuration().toSeconds());


                mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                    @Override
                    public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                        if (!mouse) {
                            processSD.setValue(newValue.toSeconds());
                            int curMin = (int)(mediaPlayer.getCurrentTime().toSeconds() / 60);
                            int curSec = ((int)mediaPlayer.getCurrentTime().toSeconds() % 60);

                            int endMin = (int)(mediaPlayer.getTotalDuration().toSeconds() / 60);
                            int endSec = ((int)mediaPlayer.getTotalDuration().toSeconds() % 60);
                            timeIndex.setText(curMin + ":" + curSec + "/" + endMin + ":" + endSec);
                        }
                    }
                });

            }
        });

    }

    @FXML
    public void playButton(){

        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playButtonIcon.setImage(new Image("com/SEGroup80/Image/Icon/playIcon2.png"));
        } else {
            playButtonIcon.setImage(new Image("com/SEGroup80/Image/Icon/stopIcon.png"));
            mediaPlayer.play();
        }
    }

    @FXML
    public void showVolumeBar() {
        volumeAnchorPane.setVisible(!volumeAnchorPane.visibleProperty().getValue());
    }

    @FXML
    public void LikeVideo() throws IOException {

        if (trainer != null){
            if (LikeImage.getOpacity() == 0.5){
                LikeImage.setOpacity(1);
                video.getLikeList().add(trainer.getUserID());
                if (trainer.getLikeList() == null) {
                    trainer.setLikeList(new ArrayList<String>());
                }
                trainer.getLikeList().add(video.getVideoID());
                likeNum += 1;
                likeNumLabel.setText(String.valueOf(likeNum));
            } else {
                LikeImage.setOpacity(0.5);
                video.getLikeList().remove(trainer.getUserID());
                trainer.getLikeList().remove(video.getVideoID());
                likeNum -= 1;
                likeNumLabel.setText(String.valueOf(likeNum));
            }
            new ModifyFileService().modifyUserFile(trainer);
            new ModifyFileService().modifyVideoFile(video);
        }
    }

    @FXML
    public void CollectVideo() throws IOException {
        if (trainer != null){
            if (CollectImage.getOpacity() == 0.5){
                CollectImage.setOpacity(1);
                video.getCollectionList().add(trainer.getUserID());
                if (trainer.getCollectList() == null) {
                    trainer.setCollectList(new ArrayList<String>());
                }
                trainer.getCollectList().add(video.getVideoID());
                collectNum += 1;
                collectNumLabel.setText(String.valueOf(collectNum));
            } else {
                CollectImage.setOpacity(0.5);
                video.getCollectionList().remove(trainer.getUserID());
                trainer.getCollectList().remove(video.getVideoID());
                collectNum -= 1;
                collectNumLabel.setText(String.valueOf(collectNum));
            }
            new ModifyFileService().modifyUserFile(trainer);
            new ModifyFileService().modifyVideoFile(video);
        }
    }

    @FXML
    public void backHome() throws IOException {
        mediaPlayer.dispose();
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(videoRootLayout, root);
    }
}
