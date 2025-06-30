package org.example;

public abstract class Command implements Executable{
    public Command(String description){
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public String description;
}
