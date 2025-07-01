package org.example;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LinkedListTest {

    @Test
    public void testAdd(){
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");

        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "B");
    }

    @Test
    public void testAddAtIndex() {
        LinkedList list = new LinkedList();

        list.add("A");
        list.add("C");
        list.add(1, "B");
        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "B");
        Assert.assertEquals(list.get(2), "C");
        Assert.assertEquals(list.size(), 3);
    }


    @Test
    public void testRemove() {
        LinkedList list = new LinkedList();

        list.add("A");
        list.add("B");
        list.add("C");
        list.remove(1);
        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "C");
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    public void testGet() {
        LinkedList list = new LinkedList();

        list.add("A");
        list.add("B");
        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "B");
    }

    @Test
    public void testSize() {
        LinkedList list = new LinkedList();

        Assert.assertEquals(list.size(), 0);
        list.add("A");
        list.add("B");
        Assert.assertEquals(list.size(), 2);
        list.remove(0);
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void testIsEmpty() {
        LinkedList list = new LinkedList();

        Assert.assertTrue(list.isEmpty());
        list.add("A");
        Assert.assertFalse(list.isEmpty());
        list.remove(0);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testMixedDataTypes() {
        LinkedList list = new LinkedList();

        list.add("String");
        list.add(123);
        list.add(45.67);
        Assert.assertEquals(list.get(0), "String");
        Assert.assertEquals(list.get(1), 123);
        Assert.assertEquals(list.get(2), 45.67);
        Assert.assertEquals(list.size(), 3);
    }
}
