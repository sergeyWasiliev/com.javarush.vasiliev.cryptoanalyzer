package readWriteFile;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.CREATE;

public class WriteFiles {

    public void writeFile(char[] encoderChar, Path filePath) {
        String content = new String(encoderChar);
        try {
            // Создает файл если его нет, дозаписывает в файл с использованием кодировки UTF-8
            Files.writeString(filePath, content + System.lineSeparator(), StandardOpenOption.APPEND, CREATE); // дозаписывает  файл, создает если нет
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

