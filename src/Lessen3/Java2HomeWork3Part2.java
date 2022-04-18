package Lessen3;

import java.util.Set;

public class Java2HomeWork3Part2 {

    public static void main(String[] args) {

        ContactList contactList = new ContactList();
        contactList.add("Petrov","89777346521");
        contactList.add("Zlodeev","89754546765");
        contactList.add("Goporukov","89777355533");
        contactList.add("Osminogov","89777346521");
        contactList.add("Variborch","89777347701");
        contactList.add("Goporukov","89777347891");
        contactList.add("Petrov","89777345432");

        Set<String> surnames = contactList.allSurnames();

        for (String surname : surnames) {
            System.out.printf("User " + surname + " has phone numbers " + contactList.get(surname));
            System.out.println();
        }
    }

}
