package app;

import readWriteFile.ReadFiles;
import service.BruteForceDecypher;
import service.Cypher;
import service.Decypher;
import validator.Validator;

import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;


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
                Path pathRead = validator.ValidPathReadFile(); //Валидация файла, возвращает путь файла для шифрования
                Path pathWrite = validator.ValidPathWriteFile(); //Валидация файла, возвращает путь для сохранения зашифрованногофайла
                int key = validator.validKey();
                readFiles.readfile(pathRead, pathWrite, key); // Читаем файл построчно и обрабатываем (шифруем)

            }
            case 2 -> {
                Path pathRead = validator.ValidPathReadFile();
                Path pathWrite = validator.ValidPathWriteFile();
                int key = validator.validKey();
                readFiles.readfile(pathRead, pathWrite, key); // Читаем файл построчно и обрабатываем (дешифруем)
            }
            case 3 -> System.out.println();//bruteForceDecypher.decoderBruteForce();
            case 0 -> {
                System.out.println("Выход");
                return;
            }
        }
    }
}


