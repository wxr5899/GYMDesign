package com.SEGroup80.Pojo.BasicPojo;

import com.SEGroup80.Pojo.UserPojo.Coach;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//包括直播课（单节，教练发布），录播课（单节，教练发布），普通视频（单节，所有人都可以发布）
public class Video {
    private String videoID;
    private String videoURL;
    private String title;
    private String description;
    private ArrayList<String> producerList;
    private String releaseTime;
    private int hit;                            //点击量
    private ArrayList<String> likeList;         //点赞，存储点赞了该视频的用户id
    private ArrayList<String> collectionList;   //收藏，存储收藏了该视频的用户id
    private ArrayList<String> commentList;     //评论，存储该视频的评论

    public Video() {

    }

    public Video(String videoURL, String title, String description, ArrayList<String> producerList, int hit, ArrayList<String> likeList, ArrayList<String> collectionList, ArrayList<String> commentList) {
        this.videoID = title + System.currentTimeMillis();
        this.videoURL = videoURL;
        this.title = title;
        this.description = description;
        this.producerList = producerList;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.releaseTime = "" + sdf.format(new Date());
        this.hit = hit;
        this.likeList = likeList;
        this.collectionList = collectionList;
        this.commentList = commentList;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getProducerList() {
        return producerList;
    }

    public void setProducerList(ArrayList<String> producerList) {
        this.producerList = producerList;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public ArrayList<String> getLikeList() {
        return likeList;
    }

    public void setLikeList(ArrayList<String> likeList) {
        this.likeList = likeList;
    }

    public ArrayList<String> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(ArrayList<String> collectionList) {
        this.collectionList = collectionList;
    }

    public ArrayList<String> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<String> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoID='" + videoID + '\'' +
                ", videoURL='" + videoURL + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", producerList=" + producerList +
                ", releaseTime='" + releaseTime + '\'' +
                ", hit=" + hit +
                ", likeList=" + likeList +
                ", collectionList=" + collectionList +
                ", commentList=" + commentList +
                '}';
    }
}
