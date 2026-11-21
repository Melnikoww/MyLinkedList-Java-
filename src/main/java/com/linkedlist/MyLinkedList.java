package com.linkedlist;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements ListMethods<T>{

    private Node<T> head;
    private Node<T> last;
    private int size;

    public MyLinkedList(){
        head = null;
        last = null;
        size = 0;
    }
    
    @Override
    public void pushBack(T value) {
        Node<T> element = new Node<>(value);
        if (size == 0){
            head = element;
            last = element;
        } else {
            last.next = element;
            last.next.prev = last;
            last = element;
        }
        size++;
    }

    @Override
    public void pushFirst(T value){
        if (size == 0) {
            pushBack(value);
            return;
        }
        else {
            Node<T> element = new Node<>(value);
            element.next = head;
            element.next.prev = element;

            head = element;
        }

        size++;

    }

    @Override
    public boolean insert(T value, int index) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Неверный индекс");
        Node<T> element = new Node<>(value);

        if (index == 0) {
            pushFirst(value);
            return true;
        }
        else if (index == size) {
            pushBack(value);
            return true;
        }
        else {
            Node<T> cur = head;
            for (int i = 0; i < index; i++){
                cur = cur.next;
            }

            element.next = cur;
            element.prev = cur.prev;
            element.next.prev = element;
            element.prev.next = element;
        }

        size++;

        return true;
    }

    @Override
    public boolean remove(T value) {
        Node<T> cur = head;
        boolean removed = false;

        while (cur != null){
            if (Objects.equals(cur.value, value)){
                unlink(cur);
                removed = true;
            }

            cur = cur.next;
        }

        return removed;
    }


    //Вспомогающий для remove
    private void unlink(Node<T> node){
        if (node.prev != null) {
            node.prev.next = node.next;
        } 
        else {
            head = node.next;
        }

        if (node.next != null){
            node.next.prev = node.prev;
        }
        else {
            last = node.prev;
        }

        size--;
    }
    
    //только по индексу
    @Override
    public boolean removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Неверный индекс");
        Node<T> cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        
        unlink(cur);

        return true;
    }

    @Override
    public T getLastElement() {
        if (last != null) return last.value;

        return null;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> cur = head;

        while (cur != null){
            if (Objects.equals(value, cur.value)){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    @Override
    public int indexOf(T value) {
        Node<T> cur = head;

        int index = 0;
        while(cur != null){
            if (Objects.equals(value, cur.value)){
                return index;
            }
            index++;
            cur = cur.next;
        }

        return -1;
    }

    @Override
    public void popBack(){
        if(last == null) {
            throw new NoSuchElementException("Пустой список");
        }

        unlink(last);
    }

    @Override
    public void popFirst(){
        if (head == null) {
            throw new NoSuchElementException("Пустой список");
        }
        unlink(head);
    }

    @Override
    public int lastIndexOf(T value) {
        Node<T> cur = last;

        int index = getSize() - 1;

        while (cur != null){
            if (Objects.equals(value, cur.value)){
                return index;
            }

            index--;
            cur = cur.prev;
        }

        return -1;

    }

    @Override
    public T getFirstElement(){
        if (head != null) return head.value;

        return null;
    }

    @Override
    public T getElementByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        if (index == 0) return getFirstElement();
        if (index == size - 1) return getLastElement();

        Node<T> cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = last;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
        }

        return cur.value;
    } 

    @Override
    public int getSize(){
        return size;
    }

    
    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString(){

        StringBuilder str = new StringBuilder();

        Node<T> cur = head;

        while (cur != null) {
            str.append(cur.value);
            str.append(" ");

            cur = cur.next;
        }

        return str.toString();
    }

    @Override
    public boolean removeFirst(T value) {
        Node<T> cur = head;

        while (cur != null){
            if (Objects.equals(cur.value, value)){
                unlink(cur);
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    @Override
    public boolean removeLast(T value) {
        Node<T> cur = last;

        while (cur != null){
            if (Objects.equals(cur.value, value)){
                unlink(cur);
                return true;
            }

            cur = cur.prev;
        }

        return false;
    }

    private static class Node<T> {
        private Node<T> prev;
        private T value;
        private Node<T> next;
        
        public Node(T value) {
            this.prev = null;
            this.value = value;
            this.next = null;
        }

    }

}
