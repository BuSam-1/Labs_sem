import collections.Organization;

public class SumOfEmployeesCount {
    public static void printSum(UserCollection userCollection) {
        int sum = 0;

        for (Organization org : userCollection.getOrganizations()) {
            sum += org.getEmployeesCount();
        }
        System.out.println("Сумма значений поля employeesCount для всех элементов коллекции: " + sum);
    }
}
