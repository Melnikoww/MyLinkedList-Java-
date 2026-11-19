# MyLinkedList

Реализация **двусвязного списка** на Java. Список написан с нуля: дженерик `MyLinkedList<T>`, узлы с ссылками `prev` / `next`, операции с головы и с хвоста.

Интерактивное меню в `App` показывает работу на элементах `Integer`. Поведение проверяется тестами JUnit.

## Возможности

- добавление: `pushFirst`, `pushBack`, `insert` по индексу
- удаление: все вхождения (`remove`), первое и последнее (`removeFirst` / `removeLast`), по индексу (`removeAt`), с концов (`popFirst` / `popBack`)
- поиск: `contains`, `indexOf`, `lastIndexOf`, доступ по индексу
- служебные: `getSize`, `isEmpty`, `clear`, `toString`

`null` считается обычным значением. Пустой `pop` бросает `NoSuchElementException`, неверный индекс — `IndexOutOfBoundsException`.

## Запуск

Нужны JDK и Maven. Из корня проекта:

```bash
mvn test
mvn package
java -jar target/MyLinkedList-1.0.jar
```

## Структура

```
src/main/java/com/linkedlist/
  ListMethods.java    # контракт списка
  MyLinkedList.java   # реализация
  App.java            # консольное меню
src/test/java/com/linkedlist/
  MyLinkedListTest.java
```
