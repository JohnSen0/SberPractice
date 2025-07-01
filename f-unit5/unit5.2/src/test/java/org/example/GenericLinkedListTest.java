package org.example;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GenericLinkedListTest {
    @Test
    public void testAdd(){
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("A");
        list.add("B");

        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "B");
    }

    @Test
    public void testAddAtIndex() {
        GenericLinkedList<String> list = new GenericLinkedList<>();

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
        GenericLinkedList<String> list = new GenericLinkedList<>();

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
        GenericLinkedList<String> list = new GenericLinkedList<>();

        list.add("A");
        list.add("B");
        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "B");
    }

    @Test
    public void testSize() {
        GenericLinkedList<String> list = new GenericLinkedList<>();

        Assert.assertEquals(list.size(), 0);
        list.add("A");
        list.add("B");
        Assert.assertEquals(list.size(), 2);
        list.remove(0);
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void testIsEmpty() {
        GenericLinkedList<String> list = new GenericLinkedList<>();

        Assert.assertTrue(list.isEmpty());
        list.add("A");
        Assert.assertFalse(list.isEmpty());
        list.remove(0);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testMixedDataTypes() {
        GenericLinkedList<Integer> intList = new GenericLinkedList<>();
        intList.add(1);
        intList.add(2);
        Assert.assertEquals(1, intList.get(0));
        Assert.assertEquals(2, intList.get(1));
        Assert.assertEquals(2, intList.size());
    }
}
