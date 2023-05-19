import collections.Address;
import collections.Coordinates;
import collections.Organization;
import collections.OrganizationType;

import java.util.Scanner;

public class Add {
    private final Scanner scanner;
    private final UserCollection userCollection;

    public Add(UserCollection userCollection) {
        scanner = new Scanner(System.in);
        this.userCollection = userCollection;

        createOrganization();
    }

    private void createOrganization() {
        String name = getString("Введите название организации: ");

        Float x = getFloat("Введите координату x: ");

        Double y = getDoubley("Введите координату y: ");

        Double annualTurnover = getDouble("Введите годовой оборот: ");

        Long employeesCount = getLong("Введите количество сотрудников: ");

        OrganizationType type = getType("Введите тип организации (COMMERCIAL, GOVERNMENT, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY): ");

        System.out.print("Введите название улицы: ");
        String street = scanner.nextLine();

        System.out.print("Введите почтовый индекс: ");
        String zipCode = scanner.nextLine();

        Organization organization = new Organization(name, new Coordinates(x, y), annualTurnover, employeesCount, type, new Address(street, zipCode));

        userCollection.addUser(organization);

        System.out.println("Организация добавлена");
    }

    private String getString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым. Пожалуйста, введите данные снова.");
            }
        } while (input.isEmpty());
        return input;
    }

    private float getFloat(String message) {
        while (true) {
            try {
                System.out.print(message);
                float value = Float.parseFloat(scanner.nextLine());
                if (value > -146) {
                    return value;
                } else {
                    System.out.println("Значение поля должно быть больше -146, попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение, попробуйте снова.");
            }
        }
    }


    private Double getDoubley(String message) {
        while (true) {
            try {
                System.out.print(message);
                Double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение, попробуйте снова.");
            }
        }
    }

    private Double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    return null;
                }
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Значение поля должно быть больше 0, попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение, попробуйте снова.");
            }
        }
    }

    private long getLong(String message) {
        while (true) {
            try {
                System.out.print(message);
                long value = Long.parseLong(scanner.nextLine());
                if (value > 0 ){
                    return value;
                }
                else {
                    System.out.println("Поле может быть null, Значение поля должно быть больше 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение, попробуйте снова.");
            }
        }
    }

    private OrganizationType getType(String message) {
        while (true) {
            try {
                System.out.print(message);
                String typeString = scanner.nextLine().toUpperCase();
                OrganizationType type = OrganizationType.valueOf(typeString);
                return type;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение, попробуйте снова.");
            }
        }
    }
}
