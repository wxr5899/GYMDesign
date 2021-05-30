package com.SEGroup80.IO;

import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Manager;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Pojo.UserPojo.User;
import com.alibaba.fastjson.JSON;
import java.io.*;
import java.util.ArrayList;


public class UserJSONFileProcessor implements JSONFileProcessor {

    final static private String TrainerFileURL = "src/main/resources/com/SEGroup80/UserFile/TrainerFile.txt";
    final static private String CoachFileURL = "src/main/resources/com/SEGroup80/UserFile/CoachFile.txt";
    final static private String ManagerFileURL = "src/main/resources/com/SEGroup80/UserFile/ManagerFile.txt";

    private String FileURL;


    /*
        @param User
        @description transform the user data into the JSON format then write it to the file
     */


    public void recoUserType(String ID){

        char identityType = ID.charAt(0);

        String filePath = null;

        if ('M' == identityType) {
            FileURL = ManagerFileURL;
        } else if ('C' == identityType) {
            FileURL = CoachFileURL;
        } else {
            FileURL = TrainerFileURL;
        }
    }

    @Override
    public void writeJSON(Object o, String ID) {

        recoUserType(ID);

        String jsonString = JSON.toJSONString(o);

        new FileProcessor().writeToFile(FileURL, jsonString);
    }

    @Override
    public ArrayList<Object> readJSON(String ID, int num) {

        recoUserType(ID);

        File file = new File(FileURL);

        ArrayList<Object> userArrayList = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            String line = null;

            if (ID.length() != 1) {

                while ((line = bufferedReader.readLine()) != null) {

                    User user = null;

                    if (FileURL.equals(ManagerFileURL)) {
                        user = JSON.parseObject(line, Manager.class);
                    } else if (FileURL.equals(CoachFileURL)) {
                        user = JSON.parseObject(line, Coach.class);
                    } else {
                        user = JSON.parseObject(line, Trainer.class);
                    }

                    if (user == null){
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return null;
                    }
                    if (user.getUserID().equals(ID)) {

                        userArrayList.add(user);
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return userArrayList;
                    }
                }
            }

            int i = 0;

            while ((line = bufferedReader.readLine()) != null && i < num) {

                User user = null;

                if (FileURL.equals(ManagerFileURL)) {
                    user = JSON.parseObject(line, Manager.class);
                } else if (FileURL.equals(CoachFileURL)) {
                    user = JSON.parseObject(line, Coach.class);
                } else {
                    user = JSON.parseObject(line, Trainer.class);
                }
                userArrayList.add(user);
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

            return userArrayList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteJSON(String ID) throws IOException {
        recoUserType(ID);
        new FileProcessor().removeLine(FileURL, "\"userID\":"+ "\""+ ID+ "\"");
    }
}
