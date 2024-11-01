import service.Cypher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFiles {
    Cypher cypher = new Cypher();

    //Читает файл по строкам через буффер
    public void readfile(Path filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(filePath), StandardCharsets.UTF_8))) {
            String lineRead;
            while ((lineRead = bufferedReader.readLine()) != null) {
                cypher.encoder(lineRead);
                //System.out.println(lineRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
