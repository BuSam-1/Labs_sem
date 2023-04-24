import java.util.Scanner;

public class RemoveLower {
    private int id;


    public void execute(UserCollection userCollection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID: ");
        int idToRemove = scanner.nextInt();
        for (int i = userCollection.getOrganizations().size() - 1; i >= 0; i--) {
            if (userCollection.getOrganizations().get(i).getId() <= idToRemove) {
                userCollection.getOrganizations().remove(i);
            }
        }
    }
}
