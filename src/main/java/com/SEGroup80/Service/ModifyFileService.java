package com.SEGroup80.Service;

import com.SEGroup80.IO.JSONFileProcessor;
import com.SEGroup80.IO.UserJSONFileProcessor;
import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.BasicPojo.Video;
import com.SEGroup80.Pojo.UserPojo.User;

import java.io.IOException;

public class ModifyFileService {

    private JSONFileProcessor userJSONFileProcessor = new UserJSONFileProcessor();
    private JSONFileProcessor videoJSONFileProcessor = new VideoJSONFileProcessor();

    public void modifyUserFile(User user) throws IOException {
        if (user != null) {
            userJSONFileProcessor.deleteJSON(user.getUserID());
            userJSONFileProcessor.writeJSON(user, user.getUserID());
        } else {
            System.out.println("The user is null so that cannot be updated!");
        }
    }

    public void modifyVideoFile(Video video) throws IOException {
        if (video != null) {
            videoJSONFileProcessor.deleteJSON(video.getVideoID());
            videoJSONFileProcessor.writeJSON(video, video.getVideoID());
        } else {
            System.out.println("The video is null so that cannot be updated!");
        }
    }
}
