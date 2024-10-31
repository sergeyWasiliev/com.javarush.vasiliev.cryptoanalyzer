import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathFile {
    //Проверяем существует ли файл по введенному пути. Если да возвращаем его
    public Path ValidPathFile() {
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
                    System.out.println("Введите корректный путь к файлу");
                }

            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }


//        while (!Files.isRegularFile(pathFile)) {
//            System.out.println("Введите корректный путь к файлу");
//            pathFile = Paths.get(scanner.nextLine());
//        }

        return pathFile;
    }

}
