public class Help {
    public static void printHelp() {
        System.out.println("Список доступных команд:");
        System.out.println("help - выводит информацию об командах");
        System.out.println("info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show - вывести в стандартный поток вывод все элементы коллекции в строковом представнлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update: обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove: удалить элемент из коллекции по его id");
        System.out.println("clear -очистить коллекцию");
        System.out.println("save - сохранить в файл");
        System.out.println("execute_script: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit - выйти");
        System.out.println("remove_lover:  удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("history : вывести последние 7 команд (без их аргументов)");
        System.out.println("sum_of_employees_count : вывести сумму значений поля employeesCount для всех элементов коллекции");
        System.out.println("filter_by_address: вывести элементы, значение поля officialAddress которых равно заданному");
        System.out.println("filter_by_name: вывести элементы, значение поля name которых содержит заданную подстроку");
    }
}
