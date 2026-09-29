package com.sugya.spg;

import java.util.*;

public class SPG {
    //Input:"era2 uoy3 woh1", Output: how are you
    public void stringQ1() {
        String s = "era2 uoy3 woh1";
        String[] words = s.split(" ");
        Arrays.sort(words, Comparator.comparingInt(word -> word.charAt(word.length() - 1)));
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuilder(word.substring(0, word.length() - 1)).reverse()).append(" ");
        }
        System.out.println(res);
    }

    //Input:["java", "python", "java", "go", "java", "go"],k=2, Output: ["java", "go"]
    public void topKFrequentWords() {
        String[] words = new String[]{"java", "python", "java", "go", "java", "go"};
        int k = 2;
        // 1. Count frequency
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String w : words) {
            frequencyMap.put(w, frequencyMap.getOrDefault(w, 0) + 1);
        }
        // 2. Sort by frequency descending
        List<String> wordsList = new ArrayList<>(frequencyMap.keySet());
        wordsList.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        // 3. Print top K
        System.out.println(wordsList.subList(0, Math.min(k, wordsList.size())));
    }
}
