package com.SEGroup80.IO;

import com.SEGroup80.Pojo.BasicPojo.Video;
import com.alibaba.fastjson.JSON;
import java.io.*;
import java.util.ArrayList;

public class VideoJSONFileProcessor implements JSONFileProcessor{

    final static private String VideoFileURL = "com/SEGroup80/Video/VideoFile.txt";

    @Override
    public void writeJSON(Object o, String ID) {

        String jsonString = JSON.toJSONString(o);
        System.out.println(jsonString);
        new FileProcessor().writeToFile(VideoFileURL, jsonString);
    }

    @Override
    public ArrayList<Object> readJSON(String ID, int num) {



        File file = new File(VideoFileURL);

        ArrayList<Object> videoArrayList = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            String line = null;

            if (ID != null) {

                while ((line = bufferedReader.readLine()) != null) {

                    Video video = null;

                    video = JSON.parseObject(line, Video.class);

                    if (video.getVideoID().equals(ID)) {
                        videoArrayList.add(video);

                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return videoArrayList;
                    }
                }
            }

            int i = 0;

            while ((line = bufferedReader.readLine()) != null && i < num) {

                Video video = null;

                System.out.println("success");

                video = JSON.parseObject(line, Video.class);

                videoArrayList.add(video);
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

            return videoArrayList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteJSON(String ID) throws IOException {
        new FileProcessor().removeLine(VideoFileURL, ID);
    }
}
