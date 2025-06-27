package org.example;

public class Book {

    public Book(String name, Author author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    // Геттеры
    public String getName(){
        return this.name;
    }
    public Author getAuthor(){
        return this.author;
    }
    public int getYear(){
        return this.year;
    }

    // Сеттеры
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(Author author){
        this.author = author;
    }
    public void setYear(int year){
        this.year = year;
    }

    // toString
    public String toString(){
        return "Название - " + name + ", " + year + "\n" + author.toString();
    }

    private String name;
    private Author author;
    private int year;
}

class Author{

    public Author(String name, String sex, String email) {
        this.name = name;
        this.sex = sex;
        this.email = email;
    }

    public Author(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    // Геттеры
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public String getEmail() {
        return email;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    public String toString(){
        if (this.email != null){
            return "Автор - " + name + ", " + sex + ", " + email + "\n";
        }
        else{
            return "Автор - " + name + ", " + sex + "\n";
        }
    }

    private String name;
    private String sex;
    private String email;
}

class Main{
    public static void main(String[] args) {
        Author author1 = new Author("Джордж Оруэл", "мужской");
        System.out.println(author1.toString());

        Author author2 = new Author("Анджей Сапковский", "мужской", "andjey3@gmail.com");
        Book book = new Book("Ведьмак: ПОСЛЕДНЕЕ ЖЕЛАНИЕ", author2, 1993);

        System.out.println(book.toString());

        book.setName("Ведьмак");
        System.out.println(book.toString());
        System.out.println(book.getName());
        System.out.println(author1.getName());

        System.out.println(book.getAuthor().toString());
    }
}