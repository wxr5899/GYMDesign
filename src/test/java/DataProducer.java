/*
    This is a java script for producing the following test data:
    1. video data
    2. User(Trainer, Manager, Coach) data
    3. Record course data
    4. Body data
    5. Comment data
 */

import com.SEGroup80.Pojo.BasicPojo.Body;
import com.SEGroup80.Pojo.BasicPojo.Comment;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.CoursePojo.RecordCourse;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Pojo.UserPojo.User;
import com.SEGroup80.Service.EnrollService;
import com.SEGroup80.Service.SearchService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataProducer {

    public static void main(String[] args) {


        EnrollService enrollService =  new EnrollService();
        SearchService searchService =  new SearchService();

        /*
            Producing comment data
         */

        int commentNum = 5;




        ArrayList<String> commentID = new ArrayList<>();
        commentID.add("C17804704781");
        commentID.add("C17704704782");
        commentID.add("C17604724783");
        commentID.add("C17504704784");
        commentID.add("C17704704782");
        commentID.add("C17604724783");
        commentID.add("C17504704784");

        ArrayList<String> commentContent = new ArrayList<>();
        commentContent.add("I've always wanted to take this course！");
        commentContent.add("The body of the teacher is so cool!");
        commentContent.add("She has my dream shpae!");
        commentContent.add("I like the background music.");
        commentContent.add("It is a little bit hard for me to follow her.");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList<String> commentTime =  new ArrayList<>();

        commentTime.add("" + sdf.format(new Date()));
        commentTime.add("" + sdf.format(new Date()));
        commentTime.add("" + sdf.format(new Date()));
        commentTime.add("" + sdf.format(new Date()));
        commentTime.add("" + sdf.format(new Date()));

        ArrayList<Comment> commentList =  new ArrayList<>();


        for (int i = 0; i < commentNum; i++) {
            Comment comment  =  new Comment(commentID.get(i), commentContent.get(i), commentTime.get(i));
            commentList.add(comment);
            enrollService.commentEnroll(comment);
        }

        ArrayList<String> commentList1 = new ArrayList<>();
        commentList1.add(commentID.get(1));
        commentList1.add(commentID.get(0));
        commentList1.add(commentID.get(2));

        ArrayList<String> commentList2 = new ArrayList<>();
        commentList2.add(commentID.get(1));
        commentList2.add(commentID.get(3));
        commentList2.add(commentID.get(4));

        ArrayList<String> commentList3 = new ArrayList<>();
        commentList3.add(commentID.get(1));
        commentList3.add(commentID.get(3));
        commentList3.add(commentID.get(0));

        ArrayList<String> commentList4 = new ArrayList<>();
        commentList4.add(commentID.get(1));
        commentList4.add(commentID.get(0));
        commentList4.add(commentID.get(4));
        commentList4.add(commentID.get(2));





        ArrayList<ArrayList> commentListList =  new ArrayList<>();
        commentListList.add(commentList1);
        commentListList.add(commentList2);
        commentListList.add(commentList3);
        commentListList.add(commentList4);


        /*
            Producing body data
         */

        int bodyNum = 6;

        ArrayList<Double> weightList = new ArrayList<>();
        weightList.add(50.5);
        weightList.add(55.2);
        weightList.add(55.5);
        weightList.add(55.3);
        weightList.add(55.4);
        weightList.add(53.5);

        ArrayList<Double> heightList = new ArrayList<>();
        heightList.add(1.62);
        heightList.add(1.65);
        heightList.add(1.67);
        heightList.add(1.67);
        heightList.add(1.70);
        heightList.add(1.70);

        ArrayList<Double> bustList =  new ArrayList<>();
        bustList.add(0.87);
        bustList.add(0.89);
        bustList.add(0.90);
        bustList.add(0.90);
        bustList.add(0.90);
        bustList.add(0.91);

        ArrayList<Double> waistList =  new ArrayList<>();
        waistList.add(0.7);
        waistList.add(0.69);
        waistList.add(0.66);
        waistList.add(0.66);
        waistList.add(0.65);
        waistList.add(0.64);
        waistList.add(0.64);

        ArrayList<Double> hipList =  new ArrayList<>();
        hipList.add(0.70);
        hipList.add(0.71);
        hipList.add(0.72);
        hipList.add(0.75);
        hipList.add(0.74);
        hipList.add(0.76);


        ArrayList<Double> BMIList =  new ArrayList<>();
        BMIList.add(21.0);
        BMIList.add(19.0);
        BMIList.add(22.0);
        BMIList.add(20.0);
        BMIList.add(20.0);
        BMIList.add(21.0);


        ArrayList<String> timeList =  new ArrayList<>();
        timeList.add("2021-02-03");
        timeList.add("2021-03-25");
        timeList.add("2021-04-25");
        timeList.add("2021-06-26");
        timeList.add("2021-07-27");
        timeList.add("2021-09-03");
        timeList.add("2021-11-06");

        ArrayList<Body> bodyArrayList =  new ArrayList<>();



        for (int i = 0; i < bodyNum; i++) {
            Body body = new Body(weightList.get(i), heightList.get(i), bustList.get(i), waistList.get(i), hipList.get(i), BMIList.get(i));
            body.setTimePoint(timeList.get(i));
            bodyArrayList.add(body);
        }


        /*
            Producing the user data:
        */

        ArrayList<String> mailList =  new ArrayList<>();
        mailList.add("@bupt.edu.cn");
        mailList.add("@qq.com");
        mailList.add("@sina.com");
        mailList.add("@163.com");
        mailList.add("@qmul.ac.uk");
        mailList.add("@qq.com");
        mailList.add("@qmul.ac.uk");
        mailList.add("@sina.com");
        mailList.add("@bupt.edu.cn");
        mailList.add("@163.com");

        // Trainer
        int trainerNum = 4;

        ArrayList<String> trainerNameList =  new ArrayList<>();
        trainerNameList.add("Xiaoran Zhou");
        trainerNameList.add("Fengke Li");
        trainerNameList.add("Shuzhou Wang");
        trainerNameList.add("Qiang Deng");
        trainerNameList.add("Qian Zheng");
        trainerNameList.add("Qiang Wang");
        trainerNameList.add("Li Cheng");
        trainerNameList.add("Fei Li");

        ArrayList<String> coachList1 = new ArrayList<>();
        coachList1.add("C17704704782");
        coachList1.add("C17604724783");

        ArrayList<String> coachList2 = new ArrayList<>();
        coachList2.add("C17804704781");
        coachList2.add("C17604724783");

        ArrayList<String> coachList3 = new ArrayList<>();
        coachList3.add("C17804704781");
        coachList3.add("C17704704782");

        ArrayList<String> coachList4 = new ArrayList<>();
        coachList4.add("C17804704781");
        coachList4.add("C17704704782");
        coachList4.add("C17604724783");

        ArrayList<ArrayList> subCoach =  new ArrayList<>();
        subCoach.add(coachList1);
        subCoach.add(coachList2);
        subCoach.add(coachList3);
        subCoach.add(coachList4);

        ArrayList<String> friendList1 = new ArrayList<>();
        friendList1.add("C17804704781");
        friendList1.add("T18735715892");

        ArrayList<String> friendList2 = new ArrayList<>();
        friendList2.add("C17804704781");
        friendList2.add("T18535715894");

        ArrayList<String> friendList3 = new ArrayList<>();
        friendList3.add("T18535715894");
        friendList3.add("T18835705891");

        ArrayList<String> friendList4 = new ArrayList<>();
        friendList4.add("T18635705893");
        friendList4.add("T18735715892");
        friendList4.add("T18835705891");

        ArrayList<ArrayList> subFriend =  new ArrayList<>();
        subFriend.add(friendList1);
        subFriend.add(friendList2);
        subFriend.add(friendList3);
        subFriend.add(friendList4);

        ArrayList<String> phoneList =  new ArrayList<>();
        ArrayList<Boolean> genderList =  new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            phoneList.add("18"+ (9-i) + "357" + (285 % i) +"589"+ i);
            if (i % 2 == 0) {
                genderList.add(true);
            } else {
                genderList.add(false);
            }
        }

        for (int i = 0; i < trainerNum; i++) {
            User trainer =  new Trainer("Trainer", "123456", trainerNameList.get(i), phoneList.get(i) + mailList.get(i), phoneList.get(i), (20 + 285 % (i+1)), genderList.get(i), 500, subCoach.get(i), subFriend.get(i), bodyArrayList);
            enrollService.userEnroll(trainer);
        }


        // Coach:
        int coachNum = 4;

        ArrayList<String> coachNameList =  new ArrayList<>();
        coachNameList.add("Xiaoran Zheng");
        coachNameList.add("Fengke Wang");
        coachNameList.add("Shuzhou Li");
        coachNameList.add("Qiang Deng");
        coachNameList.add("Qian Zhou");
        coachNameList.add("Qiang Wang");
        coachNameList.add("Li Wang");
        coachNameList.add("Fei Cheng");


        ArrayList<String> coachPhoneList =  new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            coachPhoneList.add("17"+ (9-i) + "047" + (236 % i) +"478"+ i);
        }

        for (int i = 0; i < coachNum; i++) {
            User coach =  new Coach("Coach", "123456", coachNameList.get(i), coachPhoneList.get(i) + mailList.get(i), coachPhoneList.get(i), (25 + 389 % (i + 1)), genderList.get(i), null, null);
            enrollService.userEnroll(coach);
        }

        /*
            Producing video data:
         */


        int videoNum = 4;

        ArrayList<String> videoNameList =  new ArrayList<>();
        videoNameList.add("Dance 2min");
        videoNameList.add("Dance Easy");
        videoNameList.add("Lose Weight");
        videoNameList.add("Neck 3min");
        videoNameList.add("Perfect Butt");
        videoNameList.add("Relax");
        videoNameList.add("Shoulder 3min");


        String videoSourceRoot = "src/main/resources/com/SEGroup80/Video/";

        ArrayList<String> videoUrlList = new ArrayList<>();
        for (int i = 0; i < videoNum; i++) {
            videoUrlList.add(videoSourceRoot + videoNameList.get(i)+".mp4");
        }


        ArrayList<String> videoDescriptionList =  new ArrayList<>();
        videoDescriptionList.add("Hi, there! This is a 2 minutes dance video. If you don't have much time at workplace, it will be a good choice when you are taking a short break.");
        videoDescriptionList.add("This video is quite easy but not boring. It suits for all fitness novice. Hope you enjoy it!");
        videoDescriptionList.add("This video is for those people who want to lose weight. Practice it everyday and you will find a thinner and better self.");
        videoDescriptionList.add("Are you a student or office worker with high pressure, then this video can help you to relax your neck in the mean while give you a pretty shoulder line");
        videoDescriptionList.add("Hello, everybody! I am here to teach you how to exerceise your hip. You may think it pretty difficult, but I am sure you can all make it!");
        videoDescriptionList.add("This is video will teach you how to relax your body after one-day work. There are only several easy movements. Let's get start.");
        videoDescriptionList.add("This video includes some simple gestures and movements whilch make your shoulder muscle stronger.");

        ArrayList<String> producerList1 =  new ArrayList<>();
        producerList1.add("C17604724783");
        producerList1.add("C17704704782");

        ArrayList<String> producerList2 =  new ArrayList<>();
        producerList2.add("C17804704781");
        producerList2.add("C17604724783");

        ArrayList<String> producerList3 =  new ArrayList<>();
        producerList3.add("C17804704781");
        producerList3.add("C17704704782");

        ArrayList<String> producerList4 =  new ArrayList<>();
        producerList4.add("C17504704784");
        producerList4.add("C17704704782");

        ArrayList<String> producerList5 =  new ArrayList<>();
        producerList5.add("C17804704781");
        producerList5.add("C17704704782");

        ArrayList<String> producerList6 =  new ArrayList<>();
        producerList6.add("C17704704782");
        producerList6.add("C17804704781");


        ArrayList<String> producerList7 =  new ArrayList<>();
        producerList7.add("C17704704782");
        producerList7.add("C17804704781");


        ArrayList<ArrayList> producerListList =  new ArrayList<>();
        producerListList.add(producerList1);
        producerListList.add(producerList2);
        producerListList.add(producerList3);
        producerListList.add(producerList4);
        producerListList.add(producerList5);
        producerListList.add(producerList6);
        producerListList.add(producerList7);


        ArrayList<String> videoIDList =  new ArrayList<>();
        for (int i = 0; i < videoNum; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String ID = "V" + System.currentTimeMillis();
            videoIDList.add(ID);
        }

        for (int i = 0; i < videoNum; i++) {
            Video video = new Video(videoUrlList.get(i), videoNameList.get(i), videoDescriptionList.get(i), producerListList.get(i), (int)(Math.random() * 1000), subFriend.get(i), subFriend.get(i), commentListList.get((int)(Math.random() * 4)));
            video.setVideoID(videoIDList.get(i));
            enrollService.videoEnroll(video);
        }


        /*
            Producing course data:
         */

        int courseNum = 4;

        ArrayList<String> courseNameList = new ArrayList<>();
        courseNameList.add("Back Muscle Training");
        courseNameList.add("Abdominal Muscle Training");
        courseNameList.add("Reduced Fat Movement");
        courseNameList.add("Martial Art");

        ArrayList<String> courseVideoList1 =  new ArrayList<>();
        courseVideoList1.add(videoIDList.get(3));
        courseVideoList1.add(videoIDList.get(1));

        ArrayList<String> courseVideoList2 =  new ArrayList<>();
        courseVideoList2.add(videoIDList.get(0));
        courseVideoList2.add(videoIDList.get(1));

        ArrayList<String> courseVideoList3 =  new ArrayList<>();
        courseVideoList3.add(videoIDList.get(2));
        courseVideoList3.add(videoIDList.get(1));

        ArrayList<String> courseVideoList4 =  new ArrayList<>();
        courseVideoList4.add(videoIDList.get(3));
        courseVideoList4.add(videoIDList.get(0));
        courseVideoList4.add(videoIDList.get(1));

        ArrayList<ArrayList> videoListList =  new ArrayList<>();
        videoListList.add(courseVideoList1);
        videoListList.add(courseVideoList2);
        videoListList.add(courseVideoList3);
        videoListList.add(courseVideoList4);

        ArrayList<String> courseDescription =  new ArrayList<>();
        courseDescription.add("Strong back muscles help you to develop a more upright stance and also prevent some illness. Just follow me and make it!");
        courseDescription.add("Summer is coming, let's exercise our abdominal mescles!");
        courseDescription.add("Are you annoyed with your extra fat? This course teach how to reduce fat without doing too much difficult and complex movements. Let's start!");
        courseDescription.add("Martial Art is a kind of traditional Chinese culture. If you are interested in it, just register and follow me!");
        courseDescription.add("");
        courseDescription.add("");

        for (int i = 0; i < courseNum; i++) {
            Course course = new RecordCourse(producerListList.get(i), courseNameList.get(i), "Record", subFriend.get(i), videoListList.get(i), courseDescription.get(i), (int)(Math.random() * 1000));
            enrollService.courseEnroll(course);
        }

    }

}
