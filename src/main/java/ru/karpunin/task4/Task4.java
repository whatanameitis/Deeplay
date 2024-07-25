package ru.karpunin.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        int[] nums1 = {10, 11, 7, 7, 12};
        int K1 = 2;
        printResult(nums1, K1);

        int[] nums2 = {5, 2, 6, 4, 3, 6};
        int K2 = 4;
        printResult(nums2, K2);

        int[] nums3 = {7, 8, 12, 1};
        int K3 = 3;
        printResult(nums3, K3);
    }

    public static void printResult(int[] nums, int K) {
        System.out.println("Initial values: " + Arrays.toString(nums) + ", K= " + K);
        List<List<Integer>> result = new ArrayList<>();

        if (canPartition(nums, K, result)) {
            for (List<Integer> part : result) {
                System.out.println(part + ", " + part.stream().mapToInt(Integer::intValue).sum());
            }
        } else {
            System.out.println("Impossible");
        }
        System.out.println();
    }

    public static boolean canPartition(int[] nums, int K, List<List<Integer>> result) {
        int totalSum = Arrays.stream(nums).sum();

        // Минимум мы положим в первую кучу 1, во вторую 2 и т.д, то есть получим арифметическую прогрессию длиной K
        int minSum = K * (K - 1) / 2;

        // Доложим в каждую кучу еще некоторое L
        if ((totalSum - minSum) % K != 0) {
            return false;
        }

        int L = (totalSum - minSum) / K;
        int[] targetSums = IntStream.range(0, K).map(i -> L + i).toArray();
        int[] currentSums = new int[K];
        List<Integer>[] partitions = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            partitions[i] = new ArrayList<>();
        }

        if (canPartition(nums, 0, currentSums, targetSums, partitions)) {
            result.addAll(Arrays.asList(partitions));
            return true;
        }

        return false;
    }

    private static boolean canPartition(int[] nums, int index, int[] currentSums, int[] targetSums, List<Integer>[] partitions) {

        /*
            Условие выхода из рекурсии:
                Если все числа проверены, то далее проверяем, что разбиение корректно
         */

        if (index == nums.length) {
            for (int i = 0; i < currentSums.length; i++) {
                if (currentSums[i] != targetSums[i]) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < currentSums.length; i++) {

            /*
                Для каждого числа проверяем, можно ли его поместить в i-ю кучу, а затем рекурсивно вызываем
                функцию. В случае, если число нельзя поместить ни в какую кучу, то мы "откатываемся".
                Получается полный перебор, что-то вроде дерева решений.
             */

            if (currentSums[i] + nums[index] <= targetSums[i]) {
                currentSums[i] += nums[index];
                partitions[i].add(nums[index]);
                if (canPartition(nums, index + 1, currentSums, targetSums, partitions)) {
                    return true;
                }
                currentSums[i] -= nums[index];
                partitions[i].removeLast();
            }
        }

        return false;
    }
}
