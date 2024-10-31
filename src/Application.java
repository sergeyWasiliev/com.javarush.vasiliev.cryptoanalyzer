import service.BruteForceDecypher;
import service.Cypher;
import service.Decypher;

import java.nio.file.Path;
import java.util.Scanner;


// Шифрование текста с ключем
// Расшифровка текста с ключем
// Расшифровка методом brute force
// Статистический анализ
// F:\JavaRushUniversity\Syntax level 1-26\ZonedDateTime.png
// F:\JavaRushUniversity\Projects\Modul_1_cryptoanalyzer\Task.txt

public class Application {



    public static void main(String[] args){

        Cypher cypher = new Cypher();
        Decypher decypher = new Decypher();
        BruteForceDecypher bruteForceDecypher = new BruteForceDecypher();
        PathFile pathFile = new PathFile();
        ReadFiles readFiles = new ReadFiles();


        System.out.println("ШИФРОВАНИЕ МЕТОДОМ ЦЕЗАРЯ");
        System.out.println("ВЫБЕРИТЕ ПУНКТ МЕНЮ");
        System.out.println("1. Шифрование с ключом");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Расшифровка brute force");
        System.out.println("0. ВЫХОД");
        Scanner scanner = new Scanner(System.in);
//        int exit = 1;
//        while (exit!=0) {
            int numMenu = scanner.nextInt();
            switch (numMenu) {
                case 1 -> {
                   Path path = pathFile.ValidPathFile(); //Возвращает путь к файлу
                    readFiles.readfile(path); // Читаем файл
                    //cypher.encoder("");
                }
                case 2 -> decypher.decoder();
                case 3 -> bruteForceDecypher.decoderBruteForce();
                case 0 -> {
//                    exit = 0;
                    return;
                }
            }
//        }
    }



}