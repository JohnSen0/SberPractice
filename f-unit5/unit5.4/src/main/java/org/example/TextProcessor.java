package org.example;

public class TextProcessor {

    public String[] splitToOnlyAlpha(String text){
        return text.toLowerCase().replaceAll("[^а-я^А-ЯёЁ\\s]", "").split("\\s+");
    }

}
