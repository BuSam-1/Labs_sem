import java.io.IOException;
import java.util.Scanner;

public class CollectionManager {
    Scanner scanner = new Scanner(System.in);
    String filePath;
    Update update = new Update();
    UserCollection userCollection = new UserCollection();
    private CommandHistory commandHistory = new CommandHistory();

    public CollectionManager(String filePath) {
        this.filePath = filePath;
    }


    public void run() throws IOException {

        System.out.println("help - выводит информацию об командах");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = scanner.nextLine().trim();
            commandHistory.addCommand(choice.split(" ")[0]);
            switch (choice) {
                case "info":
                    Info.printInfo();
                    break;
                case "help":
                    Help.printHelp();
                    break;
                case "add":
                    Add add = new Add(userCollection);
                    break;
                case "remove":
                    userCollection.removeById();
                    break;
                case "update":
                    update.update(userCollection);
                    break;
                case "clear":
                    Clear.clearOrganizations(userCollection);
                    break;
                case "save":
                    userCollection.saveOrganizations(filePath);
                    System.out.println("Сохранено в файл " + filePath);
                    break;
                case "show":
                    userCollection.printOrganizations();
                    break;
                case "history":
                    printCommandHistory();
                    break;
                case "sum":
                    SumOfEmployeesCount.printSum(userCollection);
                    break;
                case "filter_by_address":
                    FilterByOfficialAddress.filter(userCollection);
                    break;
                case "filter_by_name":
                    FilterByName filterByName = new FilterByName();
                    filterByName.execute(userCollection);
                    break;
                case "remove_lower":
                    RemoveLower removeLower = new RemoveLower();
                    removeLower.execute(userCollection);
                    break;
                case "execute_script":
                    if (scanner.hasNext()) {
                        String scriptFileName = scanner.next();
                        ExecuteScript executeScript = new ExecuteScript(userCollection, filePath);
                        executeScript.executeFromFile(scriptFileName);
                    } else {
                        System.out.println("Не указано имя файла скрипта");
                    }
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Некорректный ввод");
            }
        }
    }

    public void printCommandHistory() {
        commandHistory.printHistory();
    }
}
