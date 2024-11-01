import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Validator {
    //Проверяем существует ли файл по введенному пути. Если да возвращаем его
    // Обработка InvalidPathException
    public Path ValidPathReadFile() {
        System.out.println("Введите путь к файлу");
        Scanner scanner = new Scanner(System.in);
        Path pathFile = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFile = Paths.get(scanner.nextLine());
                if (Files.isRegularFile(pathFile)) {
                    validPath = true;
                } else {
                    System.out.println("Возможно это не файл или не верный путь к файлу. Введите корректный путь к файлу");
                }

            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }

        return pathFile;
    }

    public int validKey() {
        System.out.println("Введите ключ");
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        boolean validKey = false;
        while (validKey == false) {
            try {
                key = scanner.nextInt();
                validKey = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите целое число");
            }
        }

        return key;
    }


    //Проверяем существует ли файл по введенному пути.
    // Обработка InvalidPathException
    public Path ValidPathWriteFile() {
        System.out.println("Введите путь к файлу");
        Scanner scanner = new Scanner(System.in);
        Path pathFile = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFile = Paths.get(scanner.nextLine());
                validPath = true;
//                if (Files.isRegularFile(pathFile)) {
//                    validPath = true;
//                } else {
//                    System.out.println("Это скорее всего не файл. Введите корректный путь к файлу");
//                }

            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }

        return pathFile;
    }

}
