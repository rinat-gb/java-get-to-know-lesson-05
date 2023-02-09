/*
Урок 5. Хранение и обработка данных ч2: множество коллекций Map

1. Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов.

2. Пусть дан список сотрудников:

Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова,
Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
Иван Мечников, Петр Петин, Иван Ежов.

Написать программу, которая найдет и выведет повторяющиеся имена
с количеством повторений. Отсортировать по убыванию популярности.
Для сортировки использовать TreeMap.
*/
package ru.gb;

public class App 
{
    public static void main( String[] args )
    {
        Lesson lesson = new Lesson_05("Урок 5. Хранение и обработка данных ч2: множество коллекций Map");

        while (true) {
            int choice = lesson.menu();

            if (choice == -1)
                break;

            System.out.printf("Задание номер %d\n", choice + 1);
            System.out.println("===============");

            lesson.runExercise(choice);
            waitForEnter();
        }
    }

    private static void waitForEnter() {
        System.out.print("\nНажмите Enter для продолжения...");

        try {
            System.in.skip(System.in.available());
            System.in.read();
        } catch (Exception e) {
        }
        System.out.println();
    }
}
