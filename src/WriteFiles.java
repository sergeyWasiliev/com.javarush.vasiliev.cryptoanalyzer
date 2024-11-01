import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

public class WriteFiles {

        public void writeFile(char[] encoderChar) {
            Path filePath = Paths.get("output.txt");
            String content = new String(encoderChar);

            try {
                // Запись в файл с использованием кодировки UTF-8
               // Files.write(filePath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(filePath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND , CREATE);
                Files.write(filePath, "\n".getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

