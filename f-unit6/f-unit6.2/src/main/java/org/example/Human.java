package org.example;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void speak(String phrase, int n){
        for (int i = 0; i<n; i++){
            System.out.println(phrase);
        }

    }
}
