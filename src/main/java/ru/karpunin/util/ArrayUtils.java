package ru.karpunin.util;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayUtils {

    private static final Random random = new Random();

    public static int[] createRandomArray(Integer capacity) {
        return IntStream.generate(random::nextInt).limit(capacity).toArray();
    }
}
