package com.SEGroup80.IO;

import java.io.IOException;
import java.util.ArrayList;

public interface JSONFileProcessor {

    /**
     * This method is to write an object into a JSON string and become a line in .txt, which is convenient for us
     * to record the data.
     * @param o
     */
    public void writeJSON(Object o);

    /**
     * This method is to transfer the JSON string into a object
     * @param ID The ID of the object.
     * @param num The number of objects to return.
     */
    public ArrayList<Object> readJSON(String ID, int num);


    /**
     * delete a JSON line in the .txt file
     * @param courseID
     */
    public void deleteJSON(String courseID) throws IOException;

}
