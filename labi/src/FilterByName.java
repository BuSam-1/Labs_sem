import collections.Organization;

import java.util.Scanner;

public class FilterByName {

    public void execute(UserCollection userCollection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите поле Name: ");
        String name = scanner.nextLine();
        for (Organization org : userCollection.getOrganizations()) {
            if (org.getName().contains(name)) {
                System.out.println(org.toString());
            }
            else {
                System.out.println("Коллекция с таким именем не найдена");
            }
        }
    }
}

