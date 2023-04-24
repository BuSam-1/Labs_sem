import collections.Address;
import collections.Organization;

import java.util.Scanner;

public class FilterByOfficialAddress {

    public static void filter(UserCollection userCollection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите улицу: ");
        String street = scanner.nextLine();
        System.out.print("Введите почтовый индекс: ");
        String zipCode = scanner.nextLine();
        boolean found = false;
        for (Organization org : userCollection.getOrganizations()){
            Address address = org.getOfficialAddress();
            if (address.getStreet().equals(street) && address.getZipCode().equals(zipCode)) {
                System.out.println(org);
                found = true;
            }
        }
        if (!found) {
            System.out.println("По данному адресу организаций не найдено.");
        }
    }
}
