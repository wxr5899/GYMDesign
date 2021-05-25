package com.SEGroup80.Service;

import com.SEGroup80.IO.JSONFileProcessor;
import com.SEGroup80.IO.UserJSONFileProcessor;
import com.SEGroup80.Pojo.UserPojo.User;

import java.io.IOException;

public class ModifyFileService {

    private JSONFileProcessor userJSONFileProcessor = new UserJSONFileProcessor();

    public void modifyUserFile(User user) throws IOException {
        if (user != null) {
            userJSONFileProcessor.deleteJSON(user.getUserID());
            userJSONFileProcessor.writeJSON(user, user.getUserID());
        } else {
            System.out.println("The user is null so that cannot be updated!");
        }
    }
}
