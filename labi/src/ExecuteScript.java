import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class ExecuteScript {

    private final UserCollection userCollection;
    private final String filePath;
    private final Update update = new Update();
    private final CommandHistory commandHistory = new CommandHistory();
    private final Set<String> scriptFiles = new HashSet<>();

    public ExecuteScript(UserCollection userCollection, String filePath) {
        this.userCollection = userCollection;
        this.filePath = filePath;
    }

    public void executeFromFile(String fileName) {
        if (scriptFiles.contains(fileName)) {
            System.out.println("Ошибка: рекурсивный вызов execute_script недопустим");
            return;
        }

        scriptFiles.add(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String command;
            while ((command = reader.readLine()) != null) {
                executeCommand(command);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            scriptFiles.remove(fileName);
        }
    }

    private void executeCommand(String command) throws IOException {
        Scanner scanner = new Scanner(command);
        if (scanner.hasNext()) {
            String commandName = scanner.next();
            commandHistory.addCommand(commandName);
            switch (commandName) {
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
                    try {
                        userCollection.saveOrganizations(filePath);
                        System.out.println("Сохранено в файл " + filePath);
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении организаций: " + e.getMessage());
                    }
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
                        executeFromFile(scriptFileName);
                    } else {
                        System.out.println("Не указано имя файла скрипта");
                    }
                    break;
                default:
                    System.out.println("Неизвестная команда: " + commandName);
            }
        }

    }

    public void printCommandHistory() {
        commandHistory.printHistory();
    }
}
