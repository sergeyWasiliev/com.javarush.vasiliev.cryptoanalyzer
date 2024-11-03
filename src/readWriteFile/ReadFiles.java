package readWriteFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadFiles {
    //Читает файл в Stream
    public Stream<String> readfile(Path filePath) {
        try {
            return Files.lines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
