package com.SEGroup80.Service;

import com.SEGroup80.IO.CommentJSONFileProcessor;
import com.SEGroup80.IO.CourseJSONFileProcessor;
import com.SEGroup80.IO.UserJSONFileProcessor;
import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.BasicPojo.Comment;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.CoursePojo.Course;
import com.SEGroup80.Pojo.UserPojo.User;

import java.io.IOException;

public class DeleteService {

    public void deleteUser(User user) throws IOException {

        if (user == null) {
            System.out.println("The user is null!");
        } else {
            new UserJSONFileProcessor().deleteJSON(user.getUserID());
        }

    }

    public void deleteCourse(Course course) throws IOException {

        if (course == null) {
            System.out.println("The user is null!");
        } else {
            new CourseJSONFileProcessor().deleteCourse(course.getCourseID());
        }
    }


    public void deleteVideo(Video video) throws IOException {

        if (video == null) {
            System.out.println("The user is null!");
        } else {
            new VideoJSONFileProcessor().deleteJSON(video.getVideoID());
        }
    }


    public void deleteComment(Comment comment) throws IOException {

        if (comment == null) {
            System.out.println("The user is null!");
        } else {
            new CommentJSONFileProcessor().deleteComment(comment.getCommentID());
        }
    }
}
