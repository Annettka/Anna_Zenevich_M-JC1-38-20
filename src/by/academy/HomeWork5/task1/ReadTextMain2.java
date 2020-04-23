package by.academy.HomeWork5.task1;

import java.util.*;
import java.util.stream.Stream;

public class ReadTextMain2 {
    public static void main(String[] args) throws Exception {
        String data = ReadTextAsString.readFileAsString("E:\\Курсы It-academy\\Java_базовый\\Война и мир.txt");

        String[] words = (data.toLowerCase().replaceAll("[-.?!)(,:;\"]", " ")).split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, wordCount.get(word) + 1);
            }

        }

        Map<String, Integer> sortedWords = sortByValue(wordCount);
        /*for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/

        System.out.println(wordCount.get("война"));
        System.out.println(wordCount.get("мир"));
        System.out.println(wordCount.get("и"));
//        System.out.println(sortedWords);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    /*public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }*/
}
