import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

public class WriteFiles {


    public void writeFile(char[] encoderChar, Path filePath) {
        File parentFile = new File(String.valueOf(filePath)).getParentFile(); //получили директорию без файла
        filePath = Paths.get(parentFile.toPath().resolve("outputCypher2.txt").toUri()); // добалили имя файла к полученной ранее директории

        String content = new String(encoderChar); //конвертировали массив charов в строку

        try {
            // Запись в файл с использованием кодировки UTF-8
            Files.write(filePath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, CREATE); // дозаписывает с файл, создает если нет
            Files.write(filePath, "\n".getBytes(), StandardOpenOption.APPEND); //т.к. читаем по строкам добаляет возврат каретки после записанной строки
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

