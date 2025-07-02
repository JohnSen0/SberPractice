package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

    public WordCounter(){
        word_frequency = new HashMap<>();
    }

    public void countWords(String[] words){
        for(String word: words){
            if(!word.isEmpty()){
                if(!word_frequency.containsKey(word)){
                    word_frequency.put(word, 1);
                }
                else {
                    word_frequency.compute(word, (_k, value) -> value + 1);
                }
            }
        }
    }

    public void printWordFrequency(){
        // Отсортированный по алфавиту словарь
        Map<String, Integer> sorted_word_frequency = new TreeMap<>(word_frequency);

        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : sorted_word_frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private Map<String, Integer> word_frequency;
}
