package ru.karpunin.task2;

import java.util.*;
import java.util.stream.Collectors;

import static ru.karpunin.util.ArrayUtils.createRandomArray;

public class Task2 {
    public static List<Integer> findMostFrequent(List<Integer> list) {
        Map<Integer, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        long maxFrequency = Collections.max(frequencyMap.values());
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.stream(createRandomArray(10)).boxed().toList();
        System.out.println(list);
        System.out.println(findMostFrequent(list));
    }
}
