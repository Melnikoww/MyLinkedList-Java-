package com.linkedlist;

public interface ListMethods<T> {
    void pushBack(T value);
    void pushFirst(T value);
    void popBack();
    void popFirst();
    boolean insert(T value, int index);
    boolean remove(T value); // Удаление всех дубликатов по заданному value
    boolean removeAt(int index); 
    boolean removeFirst(T value); //Первое вхождение
    boolean removeLast(T value); //Последнее вхождение
    boolean isEmpty();
    boolean contains(T value);
    T getLastElement();
    T getFirstElement();
    T getElementByIndex(int index);
    void clear();
    int getSize();
    int indexOf(T value);
    int lastIndexOf(T value);
}
