package com.sugya.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStringStream {

    public void printAlphabet() {
        IntStream.rangeClosed('a', 'z').forEach(c -> System.out.print((char) c + " "));
    }

    public void mutation() {
        String original = "banana";
        char target = 'a';
        char replacement = 'o';

        String result = original.chars().mapToObj(c -> (char) c == target ? replacement : (char) c)
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(result); // Output: bonono
    }

    public void capitalizeFirstLetter() {
        String[] words = {"apple", "banana", "cherry"};
        List<String> capitalized = Arrays.stream(words).filter(word -> word != null && !word.isEmpty())
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1)).collect(Collectors.toList());
        System.out.println(capitalized); // Output: [Apple, Banana, Cherry]
    }

    public void sorting() {
        String[] words = {"cherry", "banana", "apple", "date"};
        String[] sortedWords = Arrays.stream(words).sorted((s1, s2) -> Character.compare(s1.charAt(0), s2.charAt(0)))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(sortedWords)); // Output: [apple, banana, cherry, date]
    }

    public void searchingString() {
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        String target = "apple";
        List<String> matches = Arrays.stream(words).filter(word -> word.equals(target)).collect(Collectors.toList());
        System.out.println("Matches found: " + matches.size()); // Output: 3

        long count = Arrays.stream(words).filter("banana"::equals).count();
        System.out.println("'banana' appears " + count + " times.");

        Arrays.stream(words).filter(word -> word.startsWith("b")).distinct().forEach(System.out::println); // Output: banana
    }

    public void stringFrequency() {
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Long> frequencyMap = Arrays.stream(words).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(frequencyMap);// Output: {banana=2, cherry=1, apple=3}
    }
}
