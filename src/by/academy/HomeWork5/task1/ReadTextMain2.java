package by.academy.HomeWork5.task1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReadTextMain2 {
    public static void main(String[] args) throws Exception {
        String data = ReadTextAsString.readFileAsString("E:\\Курсы It-academy\\Java_базовый\\Война и мир.txt");

        String [] words = (data.toLowerCase().replaceAll("[-.?!)(,:;\"]", " ")).split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            }else {
                wordCount.put(word, wordCount.get(word)+1);
            }

        }

        Map<String, Integer> sortedWords = sortByValue(wordCount);
        /*for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/

        System.out.println(sortedWords.get("война"));
        System.out.println(sortedWords.get("мир"));
        System.out.println(sortedWords.get("и"));
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }
}
