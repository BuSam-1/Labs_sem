import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Пожалуйста, укажите имя файла JSON в качестве аргумента командной строки.");
            System.exit(1);
        }

        String filePath = args[0];
        CollectionManager collectionManager = new CollectionManager(filePath);
        try {
            collectionManager.run();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}


