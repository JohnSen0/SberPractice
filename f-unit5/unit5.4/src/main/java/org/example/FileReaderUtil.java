package org.example;
import java.io.*;

public class FileReaderUtil {

    public String readFile(String file_path) throws IOException{
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

}
