package readWriteFile;

import service.Cypher;
import service.Decypher;
import app.Application;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class ReadFiles {
    Cypher cypher = new Cypher();
    Decypher decypher = new Decypher();
    WriteFiles writeF = new WriteFiles();

    //Читает файл по строкам через буффер
    public void readfile(Path filePathEncoder, Path filePathDecoder, int key) {
        try {

            String line = "";
            Stream<String> linesStream = Files.lines(filePathEncoder, StandardCharsets.UTF_8); //читает файл по пути filePathEncoder, в UTF_8 и преобразует в поток строк
//            Проходимся итератором по потоку и обрабатываем строки
            Iterator<String> lines = linesStream.iterator();
            while (lines.hasNext()) {
                line = lines.next();
                if (Application.numMenu == 1) {
                    //Шифрование-запись
                    char[] encoderChar = cypher.encoder(line, key); //передаем шифровальщику и получаем массив символов в зашифрованном виде
                    writeF.writeFile(encoderChar, filePathDecoder); // передаем результат шифровальщика в метод для записи в файл. также передаем путь к файлу который шифровали
                    //Расшифровка-запись
                } else if (Application.numMenu == 2) {
                    char[] decoderChar = decypher.decoder(line, key);
                    writeF.writeFile(decoderChar, filePathDecoder);
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
