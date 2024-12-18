package app;

import readWriteFile.ReadFiles;
import readWriteFile.WriteFiles;
import resources.Alphavit;
import service.CypherDecypher;
import validator.Validator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {
    public static int numMenu;

    public static void main(String[] args) {

        CypherDecypher cypher = new CypherDecypher();
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
        switch (numMenu) {
            case 1 -> {
                System.out.println("Введите путь к файлу для шифрования");
                Path pathRead = validator.ValidPathReadFile(); //Валидация файла, возвращает путь файла для шифрования
                System.out.println("Введите путь для сохранения зашифрованного файла");
                Path pathWrite = validator.ValidPathWriteFile(); //Валидация файла, возвращает путь для сохранения зашифрованногофайла
                String message = "Введите ключ, любое целое число от -2147483647 до 2147483647\n" +
                        "Логический смысл имеют ключи значениями от 0 до длины используемого алфавита\n" +
                        "В нашем случае от 0 до " + Alphavit.ALPHABET.length;
                int key = validator.validKey(message);
                System.out.println("Идет процесс шифрования файла c ключем: " + key);
                Stream<String> readFilesStream = readFiles.readfile(pathRead); // Создаем дженерализованный поток
                Iterator<String> lines = readFilesStream.iterator();
                String line;
                while (lines.hasNext()) { //читаем строки из потока с помощью итератора
                    line = lines.next();
                    char[] encoderChar = cypher.encryptDecrypt(line, key); //передаем шифровальщику строку и получаем массив символов в зашифрованном виде
                    writeFiles.writeFile(encoderChar, pathWrite); // передаем результат шифровальщика в метод для записи в файл. также передаем путь к файлу который шифровали
                }
                System.out.println("Шифрование завершено!");
            }
            case 2 -> {
                System.out.println("Введите путь к файлу для дешифровки");
                Path pathRead = validator.ValidPathReadFile();
                System.out.println("Введите путь для сохранения дешифрованного файла");
                Path pathWrite = validator.ValidPathWriteFile();
                String message = "Введите ключ для расшифровки файла";
                int key = validator.validKey(message);
                System.out.println("Идет процесс расшифровки файла...");
                Stream<String> readFilesStream = readFiles.readfile(pathRead);
                Iterator<String> lines = readFilesStream.iterator();
                String line;
                while (lines.hasNext()) {
                    line = lines.next();
                    char[] decoderChar = cypher.encryptDecrypt(line, key);
                    writeFiles.writeFile(decoderChar, pathWrite);
                }
                System.out.println("Расшифровка завершена!");
            }
            case 3 -> {
                System.out.println("Введите путь к файлу для дешифровки");
                Path pathRead = validator.ValidPathReadFile();
                System.out.println("Введите путь для сохранения дешифрованного файла в формате *.txt");
                Path pathWrite1 = validator.ValidPathWriteFile();
                System.out.println("Идет процесс расшифровки Brute Force");
                System.out.println("В результате дешифровки по указанному пути будут созданы файлы *1.txt, *2.txt ...");
                File parentFileDir = new File(String.valueOf(pathWrite1)).getParentFile(); //получили директорию без файла
                String fileName = new File(String.valueOf(pathWrite1)).getName(); //получили имя файла

                for (int key = 1; key < Alphavit.ALPHABET.length; key++) {
                    Path pathWrite = Paths.get(parentFileDir.toPath().resolve(fileName.substring(0, fileName.lastIndexOf('.')) + key + ".txt").toUri());// добалили значение key в конец имени файла переданного пользователем для сохранения результатов
                    Stream<String> readFilesStream = readFiles.readfile(pathRead);
                    Iterator<String> lines = readFilesStream.iterator();
                    String line;
                    if (key == 1) System.out.println("Идет процесс расшифровки.");
                    while (lines.hasNext()) {
                        line = lines.next();
                        char[] decoderChar = cypher.encryptDecrypt(line, key);
                        writeFiles.writeFile(decoderChar, pathWrite);
                    }
                }
                System.out.println("Расшифровка завершена!");
            }
        }
    }
}
