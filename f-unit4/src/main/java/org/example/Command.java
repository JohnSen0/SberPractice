package org.example;

public abstract class Command implements Executable{
    public Command(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String name;
    public String description;
}
