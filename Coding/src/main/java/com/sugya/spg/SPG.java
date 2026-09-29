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

    public void romanToInteger(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int currentVal = romanMap.get(s.charAt(i));
            // If the current value is less than the next value, subtract it
            if (i < length - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }
        System.out.println(total);
    }

    public void integerToRoman(int num) {
        // Values sorted in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            // Replicating the symbol as long as num is greater than or equal to the current value
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        System.out.println(roman.toString());
    }
}
