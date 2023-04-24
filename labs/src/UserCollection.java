import collections.Organization;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class UserCollection {
    private int lastId = 0;
    private static Vector<Organization> organizations = new Vector<>();
    private  Date initializationTime;

    public UserCollection() {
        this.initializationTime = new Date();
    }

    public void saveOrganizations(String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = gson.toJsonTree(organizations).getAsJsonArray();
        jsonObject.add("organizations", jsonArray);
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(jsonObject, writer);
        }
    }

    public boolean loadOrganizations(String filePath) {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonArray organizationArray = jsonObject.getAsJsonArray("organizations");
            Type organizationListType = new TypeToken<List<Organization>>(){}.getType();
            List<Organization> organizationList = gson.fromJson(organizationArray, organizationListType);
            if (organizationList != null) {
                organizations = new Vector<>(organizationList);
                for (Organization organization : organizations) {
                    if (organization.getId() > lastId) {
                        lastId = organization.getId();
                    }
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return false;
        } catch (JsonSyntaxException e) {
            System.out.println("Ошибка синтаксиса JSON: " + e.getMessage());
            return false;
        }
    }

    public static String getInfoOrganizations() {
        int size = organizations.size();
        return "Тип коллекции: Vector\nДата инициализации: " + new Date() + "\nКоличество организаций: " + size;
    }

    public void removeById() {
        System.out.println("Введите id элемента,которое хотите удалить с коллекции: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Iterator<Organization> iterator = organizations.iterator();
        while (iterator.hasNext()) {
            Organization org = iterator.next();
            if (org.getId() == id) {
                iterator.remove();
                System.out.println("Элемент с ID " + id + " удален из коллекции.");
                return;
            }
        }
        System.out.println("Элемент с ID " + id + " не найден в коллекции.");
    }



    public void addUser(Organization org) {
        lastId++;
        org.setId(lastId);
        if (!organizations.contains(org)) {
            organizations.add(org);
        } else {
            System.out.println("Найдена дублированная организация: " + org.getName());
        }
    }

    public void printOrganizations() {
        for (Organization org : organizations) {
            System.out.println(org);
        }
    }

    public static Vector<Organization> getOrganizations() {
        return organizations;
    }


    @Override
    public String toString() {
        return "{" +
                "users=\n" + organizations.toString() +
                '}';
    }
}
