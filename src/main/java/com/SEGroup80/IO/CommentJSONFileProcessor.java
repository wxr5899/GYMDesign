package com.SEGroup80.IO;

import com.SEGroup80.Pojo.BasicPojo.Comment;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;


/**
 * Title: CommentJSONFileProcessor.java
 * This class is used to process JSON file video comments
 * @author SEGroup80
 */
public class CommentJSONFileProcessor {

    final static private String CommentFileURL = "com/SEGroup80/UserFile/CommentFile.txt";

    /*
        @param Comment
        @description transform the course data into the JSON format then write it to the file
     */

    /**
     * This method transform the comment data into the JSON format then write it to the file
     * @param comment A video comment
     */
    public void writeCommentJSON(Comment comment) {

        String jsonString = JSON.toJSONString(comment);

        System.out.println(jsonString + "\n");

        new FileProcessor().writeToFile(CommentFileURL, jsonString);


    }

    /**
     * This method read from JSON file to find and return the comment with one particular comment ID
     * @param commentID A video comment's ID
     * @return A video comment
     */
    public Comment readCommentJSON(String commentID) {

        ArrayList<Comment> commentArrayList = new ArrayList<>();

        System.out.println("======Reading JSON File=====\n");


        File file = new File(CommentFileURL);

        try {

            FileInputStream fileInputStream = new FileInputStream(file);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);

                Comment comment = null;

                comment = JSON.parseObject(line, Comment.class);

                if (comment.getCommentID().equals(commentID)) {
                    return comment;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * This method delete the comment with one particular comment ID from the JSON file
     * @param commentID  A video comment's ID
     * @throws IOException An exception occur when deleting a comment
     */
    public void deleteComment(String commentID) throws IOException {

        new FileProcessor().removeLine(CommentFileURL, commentID);
    }



}
