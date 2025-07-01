package org.example;

public class LinkedList {
    private static class Node{
        Object data;
        Node next;

        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private int size;

    /**
     * Конструктор
     */
    public LinkedList(){
        head = null;
        size = 0;
    }
    /**
     * Добавляет новый элемент в список
     * @param data новый элемент
     */
    public void add(Object data){
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new_node;
        }
        size++;
    }

    /**
     * Добавляет новый элемент в список на заданный индекс
     * @param index индекс для вставки
     * @param data вставляемый элемент
     */
    public void add(int index, Object data){
        isInRange(index);
        Node new_node = new Node(data);
        if(index==0){
            new_node.next = head;
            head = new_node;
        }
        else {
            Node current = head;
            for(int i = 0; i < index-1; i++){
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
        size++;
    }
    /**
     * Метод для получения элемента по индексу
     * @param index индекс элемента
     * @return элемент под индеком index
     */
    public Object get(int index){
        isInRange(index);
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Убирает элемент по индексу
     * @param index индекс элемента
     */
    public void remove(int index){
        isInRange(index);
        if (index == 0 ){
            head = head.next;
        }
        else {
            Node current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    /**
     * Метод для получения размера списка
     * @return размер листа
     */
    public int size(){
        return size;
    }
    /**
     * Метод проверки, пуст ли список
     * @return true/false
     */
    public boolean isEmpty(){
        return size==0;
    }

    private void isInRange(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("A");
        list.add("A1");
        list.add("A2");
        list.add("C");
        list.add(4, "B");
        list.remove(3);
        System.out.println(list.get(3));
    }
}