package app;

import readWriteFile.ReadFiles;
import readWriteFile.WriteFiles;
import service.Alphavit;
import service.BruteForceDecypher;
import service.Cypher;
import service.Decypher;
import validator.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;


// Шифрование текста с ключем
// Расшифровка текста с ключем
// Расшифровка методом brute force
// Статистический анализ
// F:\JavaRushUniversity\Syntax level 1-26\ZonedDateTime.png
// F:\JavaRushUniversity\Projects\Modul_1_cryptoanalyzer\Task.txt
// F:\JavaRushUniversity\Projects\Modul_1_cryptoanalyzer\Test.txt
// F:\JavaRushUniversity\Projects\Modul_1_cryptoanalyzer\output.txt
// F:\JavaRushUniversity\Syntax level 1-26\

public class Application {
    public static int numMenu;

    public static void main(String[] args) {

        Cypher cypher = new Cypher();
        Decypher decypher = new Decypher();
        BruteForceDecypher bruteForceDecypher = new BruteForceDecypher();
        Validator validator = new Validator();
        ReadFiles readFiles = new ReadFiles();
        WriteFiles writeFiles = new WriteFiles();

        System.out.println("ШИФРОВАНИЕ МЕТОДОМ ЦЕЗАРЯ");
        System.out.println("1. Шифрование с ключом");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Расшифровка brute force");
        System.out.println("0. ВЫХОД");
        System.out.println("ВЫБЕРИТЕ ПУНКТ МЕНЮ");

        Scanner scanner = new Scanner(System.in);
        boolean validnumMenu = false;
        while (!validnumMenu) {

            try {
                numMenu = scanner.nextInt();
                if (numMenu >= 0 && numMenu <= 3) {
                    validnumMenu = true;
                } else System.out.println("Выберите пункт меню. Введите целое число от 0 до 3");

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Выберите пункт меню. Введите целое число от 0 до 3");
                scanner.nextLine();
            }
        }

//        try {
            switch (numMenu) {
                case 1 -> {
                    System.out.println("Введите путь к файлу для шифрования");
                    Path pathRead = validator.ValidPathReadFile(); //Валидация файла, возвращает путь файла для шифрования
                    System.out.println("Введите путь для сохранения зашифрованного файла");
                    Path pathWrite = validator.ValidPathWriteFile(); //Валидация файла, возвращает путь для сохранения зашифрованногофайла
                    int key = validator.validKey();
                    System.out.println("Идет процесс шифрования файла c ключем: " + key);
                    Stream<String> readFilesStream = readFiles.readfile(pathRead); // Читаем файл построчно и обрабатываем (шифруем)
                    Iterator<String> lines = readFilesStream.iterator();
                    String line;
                    while (lines.hasNext()) { //читаем строки из потока с помощью итератора
                        line = lines.next();
                        char[] encoderChar = cypher.encoder(line, key); //передаем шифровальщику и получаем массив символов в зашифрованном виде
                        writeFiles.writeFile(encoderChar, pathWrite); // передаем результат шифровальщика в метод для записи в файл. также передаем путь к файлу который шифровали
                    }
                    System.out.println("Шифрование завершено!!!");
                }
                case 2 -> {
                    System.out.println("Введите путь к файлу для дешифровки");
                    Path pathRead = validator.ValidPathReadFile();
                    System.out.println("Введите путь для сохранения дешифрованного файла");
                    Path pathWrite = validator.ValidPathWriteFile();
                    int key = validator.validKey();
                    System.out.println("Идет процесс расшифровки файла...");
                    Stream<String> readFilesStream = readFiles.readfile(pathRead);
                    Iterator<String> lines = readFilesStream.iterator();
                    String line;
                    while (lines.hasNext()) {
                        line = lines.next();
                        char[] decoderChar = decypher.decoder(line, key);
                        writeFiles.writeFile(decoderChar, pathWrite);
                    }
                    System.out.println("Расшифровка завершена!!!");
                }
                case 3 -> {
                    System.out.println("Введите путь к файлу для дешифровки");
                    Path pathRead = validator.ValidPathReadFile();
                    System.out.println("Идет процесс расшифровки Brute Force");
                    File parentFile = new File(String.valueOf(pathRead)).getParentFile(); //получили директорию без файла
                    for (int key = 1; key < Alphavit.ALPHABET.length; key++) {
                        Path pathWrite = Paths.get(parentFile.toPath().resolve("outputDecoderkey" + key + ".txt").toUri()); // добалили имя файла к полученной ранее директории
                        Stream<String> readFilesStream = readFiles.readfile(pathRead);
                        Iterator<String> lines = readFilesStream.iterator();
                        String line;
                        while (lines.hasNext()) {
                            line = lines.next();
                            char[] decoderChar = decypher.decoder(line, key);
                            writeFiles.writeFile(decoderChar, pathWrite);
                        }
                    }
                    System.out.println("Расшифровка завершена!\nРезультаты работы дешифровщика находятся в той же папке что и зашифрованный файл");
                }
            }
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
    }
}


