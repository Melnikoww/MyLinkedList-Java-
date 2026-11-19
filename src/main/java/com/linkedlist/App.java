package com.linkedlist;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Пример работы MyLinkedList на элементах Integer!

public class App 
{
    private static MyLinkedList<Integer> mylist = new MyLinkedList<>();
    private static int choise = -1;
    private static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        while (choise != 0) {
            menu();

            try {
                choise = in.nextInt();
                int element = 0;
                int index = -1;

                System.out.println("Ваш выбор: " + choise);

                switch(choise){
                    case 0:
                        break;
                    case 1:
                        System.out.println("Метод -> pushBack");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        mylist.pushBack(element);
                        System.out.println("Список после добавления: ");
                        System.out.println(mylist);
                        break;
                    case 2:
                        System.out.println("Метод -> pushFirst");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        mylist.pushFirst(element);
                        System.out.print("Список после добавления: ");
                        System.out.println(mylist);
                        break;
                    case 3:
                        System.out.println("Метод -> insert");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Введите индекс: ");
                        index = in.nextInt();
                        mylist.insert(element, index);
                        System.out.print("Список после добавления: ");
                        System.out.println(mylist);
                        break;
                    case 4:
                        System.out.println("Метод -> getSize");
                        System.out.println("Текущий размер списка: " + mylist.getSize());
                        break;
                    case 5:
                        System.out.println(mylist);
                        System.out.println("Метод -> remove (все вхождения)");
                        System.out.println("Введите число типа Integer, который вы хотите удалить из списка");
                        element = in.nextInt();
                        System.out.println("Удалено: " + mylist.remove(element));
                        System.out.print("Список после удаления: ");
                        System.out.println(mylist);
                        break;
                    case 6:
                        System.out.println(mylist);
                        System.out.println("Метод -> removeAt");
                        System.out.println("Введите индекс: ");
                        index = in.nextInt();
                        mylist.removeAt(index);
                        System.out.print("Список после удаления: ");
                        System.out.println(mylist);
                        break;
                    case 7: 
                        System.out.println("Метод -> clear");
                        mylist.clear();
                        System.out.println(mylist);
                        break;
                    case 8:
                        System.out.println(mylist);
                        break;
                    case 9:
                        System.out.println("Метод -> popBack");
                        mylist.popBack();
                        System.out.print("Список после удаления с конца: ");
                        System.out.println(mylist);
                        break;
                    case 10:
                        System.out.println("Метод -> popFirst");
                        mylist.popFirst();
                        System.out.print("Список после удаления с начала: ");
                        System.out.println(mylist);
                        break;
                    case 11:
                        System.out.println(mylist);
                        System.out.println("Метод -> removeFirst (первое вхождение)");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Удалено: " + mylist.removeFirst(element));
                        System.out.print("Список после удаления: ");
                        System.out.println(mylist);
                        break;
                    case 12:
                        System.out.println(mylist);
                        System.out.println("Метод -> removeLast (последнее вхождение)");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Удалено: " + mylist.removeLast(element));
                        System.out.print("Список после удаления: ");
                        System.out.println(mylist);
                        break;
                    case 13:
                        System.out.println("Метод -> isEmpty");
                        System.out.println("Список пуст: " + mylist.isEmpty());
                        break;
                    case 14:
                        System.out.println("Метод -> contains");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Содержится в списке: " + mylist.contains(element));
                        break;
                    case 15:
                        System.out.println("Метод -> getFirstElement");
                        System.out.println("Первый элемент: " + mylist.getFirstElement());
                        break;
                    case 16:
                        System.out.println("Метод -> getLastElement");
                        System.out.println("Последний элемент: " + mylist.getLastElement());
                        break;
                    case 17:
                        System.out.println("Метод -> getElementByIndex");
                        System.out.println("Введите индекс: ");
                        index = in.nextInt();
                        System.out.println("Элемент: " + mylist.getElementByIndex(index));
                        break;
                    case 18:
                        System.out.println("Метод -> indexOf");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Первый индекс: " + mylist.indexOf(element));
                        break;
                    case 19:
                        System.out.println("Метод -> lastIndexOf");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Последний индекс: " + mylist.lastIndexOf(element));
                        break;
                    default:
                        System.out.println("Нет такого пункта меню");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести целое число");
                in.nextLine();
            } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("=======Методы класса MyLinkedList=======");
        System.out.println("0 -> Выход!");
        System.out.println("1 -> pushBack (Добавление элемента в конец)");
        System.out.println("2 -> pushFirst (Добавление элемента в начало)");
        System.out.println("3 -> insert (Добавление элемента по индексу)");
        System.out.println("4 -> getSize (Получение текущего размера списка)");
        System.out.println("5 -> remove (Удаление всех вхождений)");
        System.out.println("6 -> removeAt (Удаление элемента по индексу)");
        System.out.println("7 -> clear (Очистка всего списка)");
        System.out.println("8 -> Показать весь текущий список");
        System.out.println("9 -> popBack (Удаление с конца)");
        System.out.println("10 -> popFirst (Удаление с начала)");
        System.out.println("11 -> removeFirst (Удаление первого вхождения)");
        System.out.println("12 -> removeLast (Удаление последнего вхождения)");
        System.out.println("13 -> isEmpty (Проверка на пустоту)");
        System.out.println("14 -> contains (Проверка наличия элемента)");
        System.out.println("15 -> getFirstElement (Первый элемент)");
        System.out.println("16 -> getLastElement (Последний элемент)");
        System.out.println("17 -> getElementByIndex (Элемент по индексу)");
        System.out.println("18 -> indexOf (Индекс первого вхождения)");
        System.out.println("19 -> lastIndexOf (Индекс последнего вхождения)");
    }
}
