package Lessen3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ContactList {

    HashMap<String, List<String>> phoneMap = new HashMap<>();


    public void add(String surname, String phone) {

        List<String> strings = phoneMap.get(surname);

        if (strings == null) {
            List<String> listOfPhones = new ArrayList<>();
            listOfPhones.add(phone);
            phoneMap.put(surname, listOfPhones);
        } else {
            strings.add(phone);
            phoneMap.put(surname, strings);
        }
    }

    public List<String> get(String surname) {
        return phoneMap.get(surname);
    }

    public Set<String> allSurnames() {
        return phoneMap.keySet();
    }
}
