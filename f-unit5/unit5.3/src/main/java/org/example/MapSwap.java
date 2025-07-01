package org.example;
import java.util.Map;
import java.util.HashMap;

public class MapSwap {
    /**
     * Меняет местами ключ и значение в словаре
     * @param input_map Map(K, V)
     * @return Map(V, K)
     * @param <K>
     * @param <V>
     */
    public static <K,V> Map<V,K> swapKeysNValues(Map<K, V> input_map){
        Map<V, K> result_map = new HashMap<>();
        for(Map.Entry<K, V> entry: input_map.entrySet()){
            result_map.put(entry.getValue(), entry.getKey());
        }
        return result_map;
    }


}