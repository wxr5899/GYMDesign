import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Service.ModifyFileService;
import com.SEGroup80.Service.SearchService;

import java.io.IOException;
import java.util.ArrayList;

public class Dataproducer2 {

    public static void main(String[] args) throws IOException {
        /*
        build Coach
         */

        ArrayList<String> courseArrayList = new ArrayList<>();

        courseArrayList.add("R1622373930996");
        courseArrayList.add("R1622374067018");
        courseArrayList.add("R1622374196195");
        courseArrayList.add("R1622374415506");


        ArrayList<Object> objectArrayList = new SearchService().SearchUser("C", 6);

        for (Object obj:objectArrayList) {
            Coach coach = (Coach) obj;
            coach.setCourseList(courseArrayList);
            new ModifyFileService().modifyUserFile(coach);
        }



    }

}
