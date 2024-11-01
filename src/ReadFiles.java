import service.Cypher;
import service.Decypher;

import java.io.*;
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
    Decypher decypher= new Decypher();
    WriteFiles writeF = new WriteFiles();

    //Читает файл по строкам через буффер
    public void readfile(Path filePath, int key) {
        try {
            String line = "";
            Stream<String> linesStream = Files.lines(filePath, StandardCharsets.UTF_8); //читает файл по пути filePath, в UTF_8 и преобразует в поток строк
//            Проходимся итератором по потоку и обрабатываем строки
            Iterator<String> lines = linesStream.iterator();
            while (lines.hasNext()) {
                line = lines.next();
                if (Application.numMenu == 1) {
                //Шифрование-запись
                    char[] encoderChar = cypher.encoder(line, key); //передаем шифровальщику и получаем массив символов в зашифрованном виде
                    writeF.writeFile(encoderChar, filePath); // передаем результат шифровальщика в метод для записи в файл. также передаем путь к файлу который шифровали
                //Расшифровка-запись
                } else if (Application.numMenu == 2) {
                    char[] decoderChar = decypher.decoder(line, key);
                    writeF.writeFile(decoderChar, filePath);
                }
            }
        } catch (UncheckedIOException e) {
            System.out.println(e.getMessage());
            System.out.println("Кодировка файла не UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
