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

    //Input: arr[] = [2, -3, 4, 1, 1, 7]  Output: 3
    public int firstPositiveMissingNumber(int[] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n];//space: O(n), Time: O(n)
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n)
                vis[arr[i] - 1] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i - 1]) {
                return i;
            }
        }
        // if all elements from 1 to n are visited, then n+1 will be first positive missing number
        return n + 1;
    }

    public boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (set.contains(complement)) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public int longestSubArrayWhoseSumIsX(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int prefSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];
            if (prefSum == sum)
                res = i + 1;
                // If prefixSum - k exists in the map then there exist such // subarray from (index of previous prefix + 1) to i.
            else if (map.containsKey(prefSum - sum))
                res = Math.max(res, i - map.get(prefSum - sum));
            if (!map.containsKey(prefSum))
                map.put(prefSum, i);
        }
        return res;
    }

    //In this there are 2 possibilities 1 is exactly length maxLen or subarray can be <=maxLen, below code is for exact length
    public int maxSumInSubArrayOfMaxLenN(int[] arr, int maxLen) {
        int windowSum = 0;
        for (int i = 0; i < maxLen; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        for (int i = maxLen; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - maxLen];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    //In this there are 2 possibilities 1 is exactly length maxLen or subarray can be <=maxLen, below code is for non-exact length
    public int maxSumInSubArrayOfMaxLenK(int[] arr, int maxLen) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        // Window of size <= n
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i >= maxLen) { // Keep window length <= n
                windowSum -= arr[i - maxLen];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
