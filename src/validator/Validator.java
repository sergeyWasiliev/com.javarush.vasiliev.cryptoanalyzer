package validator;

import java.io.File;
import java.nio.file.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    //Проверяем существует ли файл по введенному пути. Если да возвращаем его
    public Path ValidPathReadFile() {
        Scanner scanner = new Scanner(System.in);
        Path pathFileEncoder = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFileEncoder = Paths.get(scanner.nextLine());
                //Проверка на пустой файл
                File file = new File(String.valueOf(pathFileEncoder));

                if (Files.isRegularFile(pathFileEncoder) && file.length() != 0) {
                    validPath = true;
                } else if (Files.isRegularFile(pathFileEncoder) && file.length() == 0) {
                    System.out.println("Выбранный файл пустой!");
                } else {
                    System.out.println("Введите корректный путь к файлу *.txt");
                }
            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу *.txt");
            }
        }
        return pathFileEncoder;
    }

    //Проверяем что ввели целое число
    public int validKey() {
        System.out.println("Введите ключ");
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        boolean validKey = false;
        while (!validKey) {
            try {
                key = scanner.nextInt();
                System.out.println(key);
                validKey = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите целое ЧИСЛО");
                scanner.nextLine();
            }
        }
        return key;
    }

    //Запрашивает путь сохранения зашифрованного файла и возвращает его
    public Path ValidPathWriteFile() {
        Scanner scanner = new Scanner(System.in);
        Path pathFileDecoder = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFileDecoder = Paths.get(scanner.nextLine());
                if (pathFileDecoder.toString().equals("")) throw new NullPointerException();
                validPath = true;
            } catch (NullPointerException | InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }
        return pathFileDecoder;
    }
}
