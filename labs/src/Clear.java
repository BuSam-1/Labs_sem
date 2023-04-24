public class Clear {
        public static void clearOrganizations(UserCollection userCollection) {
            UserCollection.getOrganizations().removeAllElements();
            System.out.println("Коллекция очищена");
        }
}


