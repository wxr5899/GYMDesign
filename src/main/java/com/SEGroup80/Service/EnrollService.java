package com.SEGroup80.Service;

import com.SEGroup80.IO.CommentJSONFileProcessor;
import com.SEGroup80.IO.CourseJSONFileProcessor;
import com.SEGroup80.IO.UserJSONFileProcessor;
import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.BasicPojo.Comment;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.UserPojo.User;

public class EnrollService {

    public void userEnroll(User user) {

        if (user == null) {
            System.out.println("The user is null!");
        } else {
            new UserJSONFileProcessor().writeJSON(user, user.getUserID());
        }
    }

    public void courseEnroll(Course course) {

        if (course == null) {
            System.out.println("The course is null!");
        } else {
            new CourseJSONFileProcessor().writeCourseJSON(course);
        }
    }

    public void videoEnroll(Video video) {

        if (video == null) {
            System.out.println("The course is null!");
        } else {
            new VideoJSONFileProcessor().writeJSON(video, video.getVideoID());
        }
    }

    public void commentEnroll(Comment comment) {

        if (comment == null) {
            System.out.println("The course is null!");
        } else {
            new CommentJSONFileProcessor().writeCommentJSON(comment);
        }
    }
}
