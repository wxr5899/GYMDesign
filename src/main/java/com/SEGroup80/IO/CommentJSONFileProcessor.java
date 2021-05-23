package com.SEGroup80.IO;

import com.SEGroup80.Pojo.BasicPojo.Comment;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;



public class CommentJSONFileProcessor {

    final static private String CommentFileURL = "src/main/resources/com/SEGroup80/UserFile/CommentFile.txt";

    /*
        @param Comment
        @description transform the course data into the JSON format then write it to the file
     */

    public void writeCommentJSON(Comment comment) {

        String jsonString = JSON.toJSONString(comment);

        System.out.println(jsonString + "\n");

        new FileProcessor().writeToFile(CommentFileURL, jsonString);


    }

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

    public void deleteComment(String commentID) throws IOException {

        new FileProcessor().removeLine(CommentFileURL, commentID);
    }



}
