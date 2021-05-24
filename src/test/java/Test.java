import com.SEGroup80.IO.CourseJSONFileProcessor;
import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.BasicPojo.Video;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println(new CourseJSONFileProcessor().readCourseJSON("R1619524817394").toString());


    }


}

