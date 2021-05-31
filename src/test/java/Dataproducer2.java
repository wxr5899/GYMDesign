import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Service.ModifyFileService;
import com.SEGroup80.Service.SearchService;

import java.io.IOException;
import java.util.ArrayList;

public class Dataproducer2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        build Coach
         */

//        ArrayList<String> courseArrayList = new ArrayList<>();
//
//        courseArrayList.add("R1622373930996");
//        courseArrayList.add("R1622374067018");
//        courseArrayList.add("R1622374196195");
//        courseArrayList.add("R1622374415506");
//
//
//        ArrayList<Object> objectArrayList = new SearchService().SearchUser("C", 6);
//
//        for (Object obj:objectArrayList) {
//            Coach coach = (Coach) obj;
//            coach.setCourseList(courseArrayList);
//            new ModifyFileService().modifyUserFile(coach);
//        }

        ArrayList<String> photoUrlList = new ArrayList<>();

        photoUrlList.add("com/SEGroup80/Image/VideoImage/video1.png");
        photoUrlList.add("com/SEGroup80/Image/VideoImage/video2.png");
        photoUrlList.add("com/SEGroup80/Image/VideoImage/video3.png");
        photoUrlList.add("com/SEGroup80/Image/VideoImage/video4.png");
        photoUrlList.add("com/SEGroup80/Image/VideoImage/video5.png");
        photoUrlList.add("com/SEGroup80/Image/VideoImage/video6.png");
        photoUrlList.add("com/SEGroup80/Image/VideoImage/video7.png");


        ArrayList<Object> videoArrayList = new SearchService().SearchVideo(null, 6);
        for (int i = 0; i < videoArrayList.size(); i++) {
            Video video = (Video) videoArrayList.get(i);
            video.setCoverUrl(photoUrlList.get(i));
            new ModifyFileService().modifyVideoFile(video);
        }


    }

}
