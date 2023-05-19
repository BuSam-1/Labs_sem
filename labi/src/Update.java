import collections.Address;
import collections.Coordinates;
import collections.Organization;
import collections.OrganizationType;

import java.util.Scanner;

public class Update {

    private static Scanner scanner = new Scanner(System.in);
    private static UserCollection userCollection;

    public  void update(UserCollection userCollection) {
        Update.userCollection = userCollection;
        int id = getInt("Введите id элемента, который нужно обновить: ");
        boolean found = false;
        for (Organization org : userCollection.getOrganizations()) {
            if (org.getId() == id) {
                found = true;
                System.out.println("Введите новые значения для элемента " + org.getName() + ":");

                String name = getString("Название: ");
                org.setName(name);

                Float x = getFloat("Координаты x: ");
                Double y = getDouble("Координаты y: ");
                org.setCoordinates(new Coordinates(x, y));

                Double annualTurnover = getDouble("Годовой оборот: ");
                org.setAnnualTurnover(annualTurnover);
                Long employeesCount = getLong("Количество сотрудников: ");
                org.setEmployeesCount(employeesCount);

                OrganizationType type = getType("Тип организации (COMMERCIAL, GOVERNMENT, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY): ");
                org.setType(type);

                System.out.println("Почтовый адрес (улица, индекс): ");
                String street = getString("Улица: ");
                String zipCode = getString("Почтовый индекс: ");
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

    private long getLong
            (String message) {
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

    private int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
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
