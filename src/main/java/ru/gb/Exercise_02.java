package ru.gb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Пусть дан список сотрудников:

Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова,
Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
Иван Мечников, Петр Петин, Иван Ежов.

Написать программу, которая найдет и выведет повторяющиеся имена
с количеством повторений. Отсортировать по убыванию популярности.
Для сортировки использовать TreeMap.
*/
public class Exercise_02 extends Exercise {
    /**
     * Класс хранящий полные имена сотрудников
     */
    private class Employee {
        // полное имя сотрудника
        String fullName;
        // лист, хранящий полные имена тёзок по имени
        ArrayList<String> namesakes;

        /**
         * Просто конструктор для сотрудника
         */
        public Employee(String fullName) {
            this.fullName = fullName;
        }

        /**
         * Возвращает полное имя сотрудника
         */
        public String getFullName() {
            return this.fullName;
        }

        /**
         * Возвращает только имя из полного имени сотрудника
         */
        public String getJustName() {
            String[] splittedName = this.fullName.split(" ");
            return splittedName[0];
        }

        /**
         * Возвращает количество сотрудников с данным именем
         */
        public int getRepetitions() {
            if (this.namesakes != null) {
                return this.namesakes.size() + 1;
            } else {
                return 1;
            }
        }

        /**
         * Добавляет тёзку по имени в список тёзок
         */
        public void addNamesake(String sakeName) {
            if (this.namesakes == null) {
                // если тёзок ещё нет, то создаём лист тёзок
                this.namesakes = new ArrayList<>();
            }
            this.namesakes.add(sakeName);
        }

        /**
         * Возвращает список тёзок для данного сотрудника
         * 
         * @return
         */
        public ArrayList<String> getNamesakes() {
            return this.namesakes;
        }
    }

    // список всех сотрудников
    private static final String[] employees = {
            "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
            "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
            "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
            "Иван Мечников", "Петр Петин", "Иван Ежов"
    };

    public Exercise_02(String description) {
        super(description);
    }

    public void run() {
        super.run();

        // строим HashMap, учитывая повторение имйн (не полных имён, а просто имён, без
        // фамилии)
        Map<String, Employee> namesMap = new HashMap<>();

        for (String name : employees) {
            Employee newEmployee = new Employee(name);
            Employee presenEmployee = namesMap.get(newEmployee.getJustName());

            if (presenEmployee != null) {
                // такое имя уже встречается, добавляем его к текущему ключу
                presenEmployee.addNamesake(name);
            } else {
                // такого имени нет, просто добавляем его в наш HashMap
                namesMap.put(newEmployee.getJustName(), newEmployee);
            }
        }

        // создаём TreeMap с компаратором, чтобы String сортировались по убыванию
        Map<String, Employee> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((String) o2).compareTo(o1);
            }

        });

        // просто переносим наш HashMap в TreeMap, а компаратор сам
        // отсортирует имена в порядке убывания популярности
        for (Map.Entry<String, Employee> entry : namesMap.entrySet()) {
            Employee employee = entry.getValue();
            // тут хитрим, делаем строку где первые символ количество повторений,
            // а дальше уже имя
            sortedMap.put(Integer.toString(employee.getRepetitions()) + employee.getJustName(), employee);
        }

        // а теперь выводим уже отсортированый TreeMap
        for (Map.Entry<String, Employee> entry : sortedMap.entrySet()) {
            Employee employee = entry.getValue();

            StringBuffer sb = new StringBuffer("Сотрудников с именем '");

            sb.append(employee.getJustName());
            sb.append("' ");

            if (employee.getRepetitions() == 1) {
                sb.append("только один человек: ");
                sb.append(employee.getFullName());
                sb.append('\n');
            } else {
                sb.append(employee.getRepetitions());

                // этот switch необходим чтобы числительные выводились по-русски
                switch (employee.getRepetitions()) {
                    case 2:
                    case 3:
                    case 4:
                        sb.append(" человекa:\n");
                        break;
                    default:
                        sb.append(" человек:\n");
                        break;
                }
                sb.append(" человек:\n");
                sb.append("    ");
                sb.append(employee.getFullName());
                sb.append('\n');

                for (String name : employee.getNamesakes()) {
                    sb.append("    ");
                    sb.append(name);
                    sb.append('\n');
                }
            }

            System.out.println(sb);
        }

    }
}
