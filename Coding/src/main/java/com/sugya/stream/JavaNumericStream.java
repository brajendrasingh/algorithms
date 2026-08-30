package com.sugya.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaNumericStream {
    public void evenNumber() {
        //.filter(n -> n%2 == 0)
    }

    public void maxElement() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        int max = list.stream().max(Integer::compare).get();
        System.out.println(max);

        System.out.println(Arrays.stream(new int[]{1, 2, 3, 2, 4, 5, 3, 6, 2}).max().getAsInt());
    }

    public void numberStartingWithOne() {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
        //For counting element
        long count = myList.stream().count();
    }

    public void printSequence() {
        IntStream.rangeClosed(0, 9).forEach(System.out::println);
    }

    public void numericSort() {
        IntStream.of(5, 3, 8, 1).sorted().forEach(System.out::print);
        System.out.println("\n--------------");
        IntStream.of(5, 3, 8, 1).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println("");
    }

    //anyMatch(predicate), findFirst()=sequential stream, findAny()=parallel stream
    public void searchNumber() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9);
        int target = 8;
        boolean found = numbers.stream().anyMatch(n -> n == target);
        System.out.println("anyMatch():: Does " + target + " exist? " + found);

        Optional<Integer> result = numbers.stream().filter(n -> n == target).findFirst();
        result.ifPresent(n -> System.out.println("findFirst()::Found: " + n));
    }

    public void duplicates() {
        // 1st approach: by set
        int[] numbers = {1, 2, 3, 2, 4, 5, 3, 6, 2};
        Set<Integer> seen = new HashSet<>();
        int[] duplicates = Arrays.stream(numbers).filter(num -> !seen.add(num)).distinct().toArray();
        System.out.println("Duplicate numbers: " + Arrays.toString(duplicates));// Output: [2, 3]

        // 2nd approach: groupingBy
        int[] duplicate = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).mapToInt(Map.Entry::getKey).toArray();
    }

    public void updateArray() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().map(n -> n * 2).forEach(System.out::println);
    }

    public void frequencyCount() {
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 3, 6, 2);
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(frequencyMap);
    }

}
