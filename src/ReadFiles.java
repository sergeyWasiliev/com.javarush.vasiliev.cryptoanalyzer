import service.Cypher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFiles {
    Cypher cypher = new Cypher();

    //Читает файл по строкам через буффер
    public void readfile(Path filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                cypher.encoder(line);
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
