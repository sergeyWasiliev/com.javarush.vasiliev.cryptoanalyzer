package validator;

import java.io.File;
import java.nio.file.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    //Проверяем существует ли файл по введенному пути. Если да возвращаем его
    // Обработка InvalidPathException
    public Path ValidPathReadFile() {
        System.out.println("Введите путь к файлу для шифрования");
        Scanner scanner = new Scanner(System.in);
        Path pathFileEncoder = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFileEncoder = Paths.get(scanner.nextLine());
                //Проверка на непустой файл
                File file = new File(String.valueOf(pathFileEncoder));
                if (file.exists()) {
                    if (file.length() == 0) {
                        System.out.println("Выбранный файл пустой!");
                    }
                }

                if (Files.exists(pathFileEncoder) && file.length() != 0) {
                    validPath = true;
                } else {
                    System.out.println("Введите корректный путь к файлу");
                }

            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }

        return pathFileEncoder;
    }

    public int validKey() {
        System.out.println("Введите ключ");
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        boolean validKey = false;
        while (!validKey) {
            try {
                key = scanner.nextInt();
                validKey = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите целое ЧИСЛО");
                scanner.nextLine();
            }
        }

        return key;
    }


    //Заправшиваем путь куда сохранить зашифрованный файл
    // Обработка InvalidPathException
    public Path ValidPathWriteFile() {
        System.out.println("Введите путь для сохранения зашифрованного файла");
        Scanner scanner = new Scanner(System.in);
        Path pathFileDecoder = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFileDecoder = Paths.get(scanner.nextLine());
                validPath = true;
//                if (Files.isRegularFile(pathFileDecoder)) {
//                    validPath = true;
//                } else {
//                    System.out.println("Это скорее всего не путь к файлу. Введите корректный путь к файлу");
//                }

            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }

        return pathFileDecoder;
    }
}
