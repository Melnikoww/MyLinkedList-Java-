package com.linkedlist;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
    private MyLinkedList list;

    @Before
    public void setUp(){
        list = new MyLinkedList();
    }

    @Test
    public void whenAddedFirstElementIntoList(){
        int testvalue = 0;
        list.pushFirst(testvalue);

        assertEquals(1, list.getSize());
        assertEquals(testvalue, list.getFirstElement());
    }

    @Test
    public void whenAddedLastElementIntoList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);
        list.pushBack(112);

        assertEquals(4, list.getSize());
        assertEquals(112, list.getLastElement());
    }

    @Test
    public void whenRemoveLastElementFromList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);
        list.pushBack(112);

        assertTrue(list.remove(112));

        assertEquals(3, list.getSize());
        assertEquals(13, list.getLastElement());

    
    }

    @Test
    public void whenRemoveMiddleElementFromList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);

        assertTrue(list.remove(14));

        assertEquals(2, list.getSize());
        assertEquals(10, list.getFirstElement());
        assertEquals(13, list.getLastElement());

    }

    @Test
    public void whenRemoveFirstElementFromList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);

        list.remove(10);

        assertEquals(2, list.getSize());

        assertEquals(14, list.getFirstElement());
        assertEquals(13, list.getLastElement());
    }

    @Test
    public void whenRemoveDuplicatesAndMissingValue(){
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(1);

        assertTrue(list.remove(1));
        assertEquals(1, list.getSize());
        assertEquals(2, list.getElementByIndex(0));

        assertFalse(list.remove(5));
        assertFalse(list.remove(1));
    }

    @Test
    public void whenGetFirstElementFromTheList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);
        list.pushBack(112);

        assertEquals(10, list.getFirstElement());
    }

    @Test
    public void whenGetLastElementFromTheList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);
        list.pushBack(112);

        assertEquals(112, list.getLastElement());

    }

    @Test
    public void whenGetElementWithIndex1FromTheList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);
        list.pushBack(112);

        assertEquals(14, list.getElementByIndex(1));
    }

    @Test
    public void whenTheListHave4ElementsAndAfterClear() {
        list.pushBack(1000);
        list.pushBack(1121);
        list.pushBack(12121212);
        list.pushBack(0);

        list.clear();

        assertEquals(0, list.getSize());
        assertEquals(null, list.getFirstElement());
        assertEquals(null, list.getLastElement());

    }

    @Test
    public void whenGetFirstElementFromEmptyListReturnsNull() {
        assertEquals(null, list.getFirstElement());
    }

    @Test
    public void whenGetLastElementFromEmptyListReturnsNull() {
        assertEquals(null, list.getLastElement());
    }

    @Test
    public void whenRemovesMissingValueReturnsFalse(){
        list.pushBack(100);
        list.pushBack(0);
        list.pushBack(-10);

        assertFalse(list.remove(20));
        assertEquals(100, list.getFirstElement());
        assertEquals(0, list.getElementByIndex(1));
        assertEquals(-10, list.getElementByIndex(2));
    }

    @Test
    public void whenRemovesNullValueFromTheList(){
        list.pushBack(10);
        list.pushBack(null);
        list.pushBack(30);
        list.pushBack(40);
        list.pushBack(-100);

        assertTrue(list.remove(null));
        assertEquals(4, list.getSize());
        assertEquals(Integer.valueOf(10), list.getElementByIndex(0));
        assertEquals(Integer.valueOf(30), list.getElementByIndex(1));
        assertEquals(Integer.valueOf(40), list.getElementByIndex(2));
        assertEquals(Integer.valueOf(-100), list.getElementByIndex(3));
        assertFalse(list.remove(null));
        
    }

    @Test
    public void whenInsertElementIntoList(){
        list.pushBack(10);
        list.pushBack(14);
        list.pushBack(13);
        list.pushBack(112);

        list.insert(15, 2);

        assertEquals(5, list.getSize());
        assertEquals(10, list.getFirstElement());
        assertEquals(14, list.getElementByIndex(1));
        assertEquals(15, list.getElementByIndex(2));
        assertEquals(13, list.getElementByIndex(3));
        assertEquals(112, list.getElementByIndex(4));
            
    }

    @Test
    public void whenInsertElementIntoEmptyListThenUpdatesHead(){
        list.insert(-10, 0);

        assertEquals(1, list.getSize());
        assertEquals(-10, list.getFirstElement());
    }


    @Test
    public void whenInsertElementIntoEmptyListThenUpdatesLast(){
        list.insert(-10, 0);

        assertEquals(1, list.getSize());
        assertEquals(-10, list.getLastElement());
    }

    @Test
    public void whenInsertElementIntoListHeadPosition(){
        list.pushFirst(10);
        list.pushBack(100);

        list.insert(-10000, 0);

        assertEquals(3, list.getSize());
        assertEquals(-10000, list.getFirstElement());
    }


    @Test
    public void whenInsertElementIntoListTailPosition(){
        list.pushFirst(10);
        list.pushBack(100);

        list.insert(-10000, list.getSize());

        assertEquals(3, list.getSize());
        assertEquals(-10000, list.getLastElement());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void whenInsertNegativeIndexThenThrowsIndexOutOfBoundException(){
        list.insert(0, -1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void whenInsertOutOfBoundsIndexThenThrowsIndexOutOfBoundException(){
        list.pushBack(10);
        list.pushBack(100);
        list.pushBack(0);

        list.insert(0, 10);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void whenRemovesNegativeIndexThenThrowsIndexOutOfBoundException(){
        list.removeAt(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void whenRemovesOutOfBoundsIndexThenThrowsIndexOutOfBoundException(){
        list.pushBack(10);
        list.pushBack(100);
        list.pushBack(0);

        list.removeAt(10);
    }

    @Test
    public void whenRemovesOnlyOneElementByIndexThenListEmpty(){
        list.pushBack(100);

        assertTrue(list.removeAt(0));

        assertEquals(0, list.getSize());
    }

    @Test
    public void whenPushBackAfterClearListThenWorkAgain(){
        list.pushBack(100);

        list.clear();

        assertEquals(0, list.getSize());
        assertEquals(null, list.getFirstElement());

        list.pushBack(-199);
        
        assertEquals(1, list.getSize());
        assertEquals(-199, list.getFirstElement());
    }

    @Test
    public void whenRemovesElementByIndex0FromList(){
        list.pushBack(10000);
        list.pushBack(2);
        list.pushBack(0);
        list.pushBack(-1);

        assertTrue(list.removeAt(0));
        assertEquals(3, list.getSize());
        assertEquals(2, list.getFirstElement());
        assertEquals(0, list.getElementByIndex(1));
        assertEquals(-1, list.getLastElement());
    }

    @Test
    public void whenRemovesLastElementByIndexFromList(){
        list.pushBack(10000);
        list.pushBack(2);
        list.pushBack(0);
        list.pushBack(-1);

        assertTrue(list.removeAt(list.getSize() - 1));
        assertEquals(3, list.getSize());
        assertEquals(10000, list.getFirstElement());
        assertEquals(2, list.getElementByIndex(1));
        assertEquals(0, list.getLastElement());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void whenRemoveByIndexInEmptyListThenThrowsIndexOutOfBoundsException(){
        list.removeAt(10);
    }

    @Test
    public void whenListIsNotEmptyAndPushFirst() {
        list.pushBack(-102);
        list.pushBack(0);

        list.pushFirst(1);

        assertEquals(3, list.getSize());
        assertEquals(1, list.getFirstElement());
    }


    @Test
    public void whenListIsEmptyThenReturnsTrue(){
        assertTrue(list.isEmpty());
    }


    @Test
    public void whenListIsNotEmptyThenReturnsFalse(){
        list.pushBack(100);


        assertFalse(list.isEmpty());
    }

    @Test
    public void whenValueNotContainsInTheListThenReturnsFalse(){
        list.pushBack(1000);
        list.pushBack(1);
        list.pushFirst(1212);

        assertFalse(list.contains(100000));
    }

    @Test
    public void whenValueContainsInTheListThenReturnsTrue(){
        list.pushBack(1000);
        list.pushBack(1);
        list.pushFirst(1212);

        assertTrue(list.contains(1));
    }

    @Test
    public void whenValueIsNullContainsInTheListThenReturnsTrue(){
        list.pushBack(null);
        list.pushBack(1);
        list.pushFirst(1212);

        assertTrue(list.contains(null));
    }

    @Test
    public void whenElementNotContainsInTheListThenReturnsNegative1_IndexOf(){
        list.pushBack(-1);
        list.pushBack(1212);

        assertEquals(-1, list.indexOf(1212143));
    }

    @Test
    public void whenElementNotContainsInTheListThenReturnsNegative1_lastIndexOf(){
        list.pushBack(-1);
        list.pushBack(1212);

        assertEquals(-1, list.lastIndexOf(1212143));
    }

    @Test
    public void whenElementContainsInTheListThenReturnsFirstIndex_IndexOf(){
        list.pushBack(-1);
        list.pushBack(1212);

        assertEquals(1, list.indexOf(1212));
    }

    @Test
    public void whenElementContainsInTheListThenReturnsFirstIndex_lastIndexOf(){
        list.pushBack(-1);
        list.pushBack(1212);
        list.pushBack(1);
        list.pushBack(1224212);
        list.pushBack(1243);
        list.pushBack(1212);
        list.pushBack(12124);

        assertEquals(5, list.lastIndexOf(1212));
    }

    @Test(expected=NoSuchElementException.class)
    public void whenPopLastElementInEmptyListThenThrowNoSuchElementException(){
        list.popBack();
    }

    @Test(expected=NoSuchElementException.class)
    public void whenPopFirstElementInEmptyListThenThrowNoSuchElementException(){
        list.popFirst();
    }

    @Test
    public void whenPopLastElementInTheList(){
        list.pushBack(1212);
        list.pushBack(121213);
        list.pushFirst(12112121);
        list.pushBack(-122);

        list.popBack();

        assertEquals(3, list.getSize());
        assertEquals(121213, list.getLastElement());

    }

    @Test
    public void whenPopFirstElementInTheList(){
        list.pushBack(1212);
        list.pushBack(121213);
        list.pushFirst(12112121);
        list.pushBack(-122);

        list.popFirst();

        assertEquals(3, list.getSize());
        assertEquals(1212, list.getFirstElement());

    }

    @Test
    public void whenRemoveFirstElementByValueInList() {
        list.pushBack(10);
        list.pushBack(121);
        list.pushBack(121311);
        list.pushBack(121);

        list.removeFirst(121);

        assertEquals(3, list.getSize());
        assertEquals(10, list.getFirstElement());
        assertEquals(121311, list.getElementByIndex(1));
        assertEquals(121, list.getLastElement());
    }

    @Test
    public void whenRemoveLastElementByValueInList() {
        list.pushBack(10);
        list.pushBack(121);
        list.pushBack(121311);
        list.pushBack(121);

        list.removeLast(121);

        assertEquals(3, list.getSize());
        assertEquals(10, list.getFirstElement());
        assertEquals(121, list.getElementByIndex(1));
        assertEquals(121311, list.getLastElement());
    }


    

}
