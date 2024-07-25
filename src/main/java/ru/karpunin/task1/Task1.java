package ru.karpunin.task1;

import java.util.*;
import java.util.stream.IntStream;

import static ru.karpunin.util.ArrayUtils.createRandomArray;

public class Task1 {
    public static int[] customOrder(final int[] array) {
        return IntStream.of(array)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(n -> n == 0 ? 1 : (n % 2 == 0 ? 2 : 0))
                        .thenComparingInt(n -> n % 2 != 0 ? n : -n))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(10);
        System.out.println("Random array: " + Arrays.toString(array));
        System.out.println("Array after custom sort: " + Arrays.toString(customOrder(array)));
    }
}
