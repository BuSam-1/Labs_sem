import collections.Address;
import collections.Coordinates;
import collections.Organization;
import collections.OrganizationType;

import java.util.Scanner;

public class Update {

    public void update(UserCollection userCollection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id элемента, который нужно обновить: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Organization org : userCollection.getOrganizations()) {
            if (org.getId() == id) {
                found = true;
                System.out.println("Введите новые значения для элемента " + org.getName() + ":");
                System.out.print("Название: ");
                String name = scanner.next();
                org.setName(name);
                System.out.println("Координаты (x y): ");
                System.out.print("x: ");
                float x = scanner.nextFloat();
                System.out.print("y: ");
                Double y = scanner.nextDouble();
                org.setCoordinates(new Coordinates(x, y));
                System.out.print("Годовой оборот: ");
                Double annualTurnover = scanner.nextDouble();
                org.setAnnualTurnover(annualTurnover);
                System.out.print("Количество сотрудников: ");
                Long employeesCount = scanner.nextLong();
                org.setEmployeesCount(employeesCount);
                System.out.print("Тип организации (COMMERCIAL, GOVERNMENT, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY): ");
                String typeStr = scanner.next();
                OrganizationType type = OrganizationType.valueOf(typeStr.toUpperCase());
                org.setType(type);
                System.out.println("Почтовый адрес (улица, индекс): ");
                System.out.print("улица: ");
                String street = scanner.next();
                System.out.print("почтовый индекс: ");
                String zipCode = scanner.next();
                Address postalAddress = new Address(street, zipCode);
                org.setOfficialAddress(postalAddress);
                System.out.println("Элемент с ID " + id + " успешно обновлен.");
                break;
            }
        }
        if (!found) {
            System.out.println("Элемент с ID " + id + " не найден в коллекции.");
        }
    }
}
