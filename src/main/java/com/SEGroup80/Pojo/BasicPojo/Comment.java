package com.SEGroup80.Pojo.BasicPojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    private String commentID;
    private String userID;
    private String commentContent;
    private String commentTime;

    public Comment(String userID, String commentContent, String commentTime) {
        this.commentID = "COM" + userID + System.currentTimeMillis();
        this.userID = userID;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = "com" + commentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    private void setCommentTime() {
        long l = System.currentTimeMillis();
        Date d = new Date(l);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.commentTime = df.format(d);
    }

    public String getCommentTime() {
        return commentTime;
    }
}
