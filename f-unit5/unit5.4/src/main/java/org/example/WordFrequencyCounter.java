package org.example;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.TreeMap;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String file_path = "unit5.4/input.txt";
        Map<String, Integer> word_frequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))){
            // Подсчет слов в файле
            String line;
            while ((line=reader.readLine()) != null){
                String[] words = line.toLowerCase().split("\\s+");
                for(String word: words){
                    word = word.replaceAll("[^а-я^А-ЯёЁ]", "");
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
        }
        catch (IOException e){
            System.out.println("Ошибка при чтении файла");
        }

        // Отсортированный по алфавиту словарь
        Map<String, Integer> sorted_word_frequency = new TreeMap<>(word_frequency);

        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : sorted_word_frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}