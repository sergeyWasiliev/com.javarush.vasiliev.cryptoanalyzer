import service.Cypher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class ReadFiles {
    Cypher cypher = new Cypher();

    //Читает файл по строкам через буффер
    public void readfile(Path filePath) {
        try {
            String line = "";
            Iterator<String> lines = Files.lines(filePath, StandardCharsets.UTF_8).iterator();
            while (lines.hasNext()) {
                line = lines.next();
                cypher.encoder(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
