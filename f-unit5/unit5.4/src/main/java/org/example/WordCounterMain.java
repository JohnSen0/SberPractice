package org.example;
import java.util.HashMap;
import java.util.Map;
import java.io.*;


public class WordCounterMain {

    public void processFile(String file_path){


        Map<String, Integer> word_frequency = new HashMap<>();
    }


    public static void main(String[] args) {
        String file_path = "unit5.4/input.txt";
        try {
            FileReaderUtil file_reader = new FileReaderUtil();
            TextProcessor text_processor = new TextProcessor();
            WordCounter word_counter = new WordCounter();

            String lines = file_reader.readFile(file_path);
            String[] words = text_processor.splitToOnlyAlpha(lines);

            word_counter.countWords(words);
            word_counter.printWordFrequency();
        }
        catch (IOException e){
            System.out.println("Ошибка при чтении файла");
        }
    }
}