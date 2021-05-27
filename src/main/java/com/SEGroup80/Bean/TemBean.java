package com.SEGroup80.Bean;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Manager;
import com.SEGroup80.Pojo.UserPojo.Trainer;
 /*
    This a class for storing the data temporary to make the data share between controller more convenient.
  */

public class TemBean {
    private static Trainer trainer;
    private static Manager manager;
    private static Coach coach;
    private static Video video;
    private static String identity;

    /*
        .txt URL List
     */
    private final static String VideoTXTFileURL = "src/main/resources/com/SEGroup80/Video/VideoFile.txt";

    public TemBean() {
    }

    public static Trainer getTrainer() {
        return trainer;
    }

    public static void setTrainer(Trainer trainer) {
        TemBean.trainer = trainer;
    }

    public static Manager getManager() {
        return manager;
    }

    public static void setManager(Manager manager) {
        TemBean.manager = manager;
    }

    public static Coach getCoach() {
        return coach;
    }

    public static void setCoach(Coach coach) {
        TemBean.coach = coach;
    }

    public static Video getVideo() {
        return video;
    }

    public static void setVideo(Video video) {
        TemBean.video = video;
    }

    public static String getVideoTXTFileURL() {
        return VideoTXTFileURL;
    }

    public static String getIdentity() {
        return identity;
    }

    public static void setIdentity(String identity) {
        TemBean.identity = identity;
    }

    @Override
    public String toString() {
        return "TemBean{" +
                "trainer=" + trainer +
                ", manager=" + manager +
                ", coach=" + coach +
                ", video=" + video +
                '}';
    }
}
