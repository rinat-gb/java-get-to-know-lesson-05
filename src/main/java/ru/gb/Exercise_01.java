package ru.gb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов.
*/
public class Exercise_01 extends Exercise {
    private static final String[] phones = {
            "Иван Иванов +7-916-123-4567",
            "Пётр Петров +7-916-234-5678",
            "Василий Васильев +7-916-345-6789",
            "Иван Иванов +7-909-456-4567",
            "Василий Васильев +7-916-999-0101",
            "Иван Иванов +7-916-876-9876",
            "Пётр Петров +7-916-100-2343",
            "Сидор Сидоров +7-916-765-5353"
    };

    public Exercise_01(String description) {
        super(description);
    }

    public void run() {
        super.run();

        System.out.println();
        System.out.println("Даны люди и телефоны:");
        System.out.println();

        for (String phone : phones) {
            System.out.println(phone);
        }

        Map<String, ArrayList<String>> phoneBook = new HashMap<>();

        for (String phone : phones) {
            String entryName = phone.substring(0, phone.lastIndexOf(' '));
            String entryPhone = phone.substring(phone.lastIndexOf(' ') + 1);

            ArrayList<String> listPhones = phoneBook.get(entryName);

            if (listPhones != null) {
                listPhones.add(entryPhone);
            } else {
                listPhones = new ArrayList<String>();
                listPhones.add(entryPhone);
                phoneBook.put(entryName, listPhones);
            }
        }

        System.out.println();
        System.out.println("После добавления в HashMap:");
        System.out.println();

        for (String entryName : phoneBook.keySet()) {
            ArrayList<String> listPhones = phoneBook.get(entryName);

            if (listPhones.size() == 1){
                System.out.println("У '"+ entryName + "' лишь один телефон: " + listPhones.get(0));
            }
            else{
                System.out.println("Список телефонов для '" + entryName + "'");
                for (String phoneNum : listPhones) {
                    System.out.println("  " + phoneNum);
                }
            }
            System.out.println();
        }
    }
}
