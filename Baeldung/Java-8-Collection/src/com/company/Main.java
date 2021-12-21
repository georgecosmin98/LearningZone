package com.company;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

//        1. The toList collector can be used for collecting all Stream elements into a List instance.
//        List<String> result = givenList.stream()
//                .collect(toList());

//        2. Java 10 introduced a convenient way to accumulate the Stream elements into an unmodifiable List:
//        List<String> result = givenList.stream()
//                .collect(toUnmodifiableList());

//        3. The toSet collector can be used for collecting all Stream elements into a Set instance
//        Set<String> result = givenList.stream()
//                .collect(toSet());

//        4. Since Java 10, we can easily create an unmodifiable Set using the toUnmodifiableSet() collector:
//        Set<String> result = givenList.stream()
//                .collect(toUnmodifiableSet());

//        5. Collectors to Collection
//        List<String> result = givenList.stream()
//                .collect(toCollection(LinkedList::new));

//        6. Collectors.toMap()
//        Map<String, Integer> result = givenList.stream()
//                .collect(toMap(Function.identity(), String::length));
//
//        result.forEach((k,v) -> {
//            System.out.println("Key: " + k + " -> " + "Value:" + v);
//        });

//        7.Joining collector can be used for joining Stream<String> elements.
//        String result = givenList.stream()
//                .collect(joining());
//        System.out.println(result);

//        7.1 We can also specify custom separators:
//        String result = givenList.stream()
//                .collect(joining(" "));
//        System.out.println(result);

//        7.1 We can also specify custom separators, prefixes, postfixes:
//        String result = givenList.stream()
//                .collect(joining(" ", "PRE-", "-POST"));
//        System.out.println(result);

//        8. Counting is a simple collector that allows for the counting of all Stream elements.
//        Long result = givenList.stream()
//                .collect(counting());
//        System.out.println(result);

//        9. SummarizingDouble/Long/Int is a collector that returns a special class containing statistical information
//        about numerical data in a Stream of extracted elements.
//        DoubleSummaryStatistics result = givenList.stream()
//                .collect(summarizingDouble(String::length));
//        System.out.println(result);

//        10. AveragingDouble/Long/Int is a collector that simply returns an average of extracted elements.
//        Double result = givenList.stream()
//                .collect(averagingDouble(String::length));
//        System.out.println(result);

//        11. SummingDouble/Long/Int is a collector that simply returns a sum of extracted elements.
//        Double result = givenList.stream()
//                .collect(summingDouble(String::length));
//        System.out.println(result);

//        12. MaxBy/MinBy collectors return the biggest/smallest element of a Stream according to a provided Comparator instance.
//        Optional<String> result = givenList.stream()
//                .collect(maxBy(Comparator.naturalOrder()));
//        result.stream().forEach(System.out::println);

//        13. GroupingBy collector is used for grouping objects by some property, and then storing the results in a Map instance.
//        Map<Integer, Set<String>> result = givenList.stream()
//                .collect(groupingBy(String::length, toSet()));
//        result.forEach((k, v) -> {
//            System.out.println("Key: " + k + " -> " + "Value:" + v);
//        });

//        14. PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance,
//        and then collects Stream elements into a Map instance that stores Boolean values as keys and collections as values.
        Map<Boolean, List<String>> result = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));
        result.forEach((k, v) -> {
            System.out.println("Key: " + k + " -> " + "Value:" + v);
        });

//        15. Let's find the maximum and minimum numbers from a given Stream using the collectors we've learned so far:
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
//        Optional<Integer> min1 = numbers.stream().collect(minBy(Integer::compareTo));
//        Optional<Integer> max1 = numbers.stream().collect(maxBy(Integer::compareTo));

//        15.1 Before Java 12, in order to cover such use cases, we had to operate on the given Stream twice,
//        store the intermediate results into temporary variables, and then combine those results afterwards.
//        numbers.stream().collect(teeing(
//                minBy(Integer::compareTo), // The first collector
//                maxBy(Integer::compareTo), // The second collector
//                (min, max) -> {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(min.get());
//                    list.add(max.get());
//                    return list;
//                }// Receives the result from those collectors and combines them
//        )).forEach(System.out::println);

//        result.stream().forEach(System.out::println);
//        result.stream()
//                .forEach(System.out::println);

    }
}
