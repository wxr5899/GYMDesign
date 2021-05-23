import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.BasicPojo.Video;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object video = new Video();

        Class obj = Class.forName("com.SEGroup80.Pojo.BasicPojo.Video");

        Video video1 = (Video) obj.newInstance();

        video1.setVideoID("1");

        System.out.println(video1.getVideoID());
    }


}

