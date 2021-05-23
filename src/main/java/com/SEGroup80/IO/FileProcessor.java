package com.SEGroup80.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor {

    public void writeToFile(String URL, String jsonString){
        try {
            // create output stream
            FileWriter fileWriter = new FileWriter(URL, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            // add the string to the file
            bufferedWriter.append(jsonString).append("\r");

            // close the output stream
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeLine(String fileURL, String lineContent) throws IOException {

        File file = new File(fileURL);
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
