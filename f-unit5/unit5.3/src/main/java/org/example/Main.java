package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Тестовый пример
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("один", 1);
        inputMap.put("два", 2);
        inputMap.put("три", 3);

        System.out.println("Map до: " + inputMap);
        Map<Integer, String> swappedMap = MapSwap.swapKeysNValues(inputMap);
        System.out.println("Map после: " + swappedMap);
    }
}
