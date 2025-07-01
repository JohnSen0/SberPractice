package org.example;

public class GenericLinkedList<T> {
    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    private int size;

    /**
     * Конструктор
     */
    public GenericLinkedList(){
        head = null;
        size = 0;
    }
    /**
     * Добавляет новый элемент в список
     * @param data новый элемент
     */
    public void add(T data){
        Node<T> new_node = new Node<>(data);
        if (head == null) {
            head = new_node;
        }
        else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current = new_node;
        }
        size++;
    }

    /**
     * Добавляет новый элемент в список на заданный индекс
     * @param index индекс для вставки
     * @param data вставляемый элемент
     */
    public void add(int index, T data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> new_node = new Node<>(data);
        if(index==0){
            new_node.next = head;
            head = new_node;
        }
        else {
            Node<T> current = head;
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
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for(int i = 0; i < index-1; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Убирает элемент по индексу
     * @param index индекс элемента
     */
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0 ){
            head = head.next;
        }
        else {
            Node<T> current = head;
            for(int i = 0; i < index-1; i++){
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
}