package readWriteFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadFiles {
    //Читает файл в Stream
    public Stream<String> readfile(Path filePath) throws IOException {
        return Files.lines(filePath, StandardCharsets.UTF_8);
    }
}
