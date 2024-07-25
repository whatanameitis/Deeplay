package ru.karpunin.task3;

import java.util.Random;

public class Task3 {
    private static final int N_SIMULATIONS = 100000;
    private static final int N_ROLLS = 10000;

    private static final Random random = new Random();

    public static void main(String[] args) {
        calculateProbability();
    }

    private static int countEntries(int[] rolls, int[] sequence) {
        int count = 0;
        for (int i = 0; i <= rolls.length - sequence.length; i++) {
            boolean match = true;
            for (int j = 0; j < sequence.length; j++) {
                if (rolls[i + j] != sequence[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
                i += sequence.length - 1;
            }
        }
        return count;
    }

    private static void calculateProbability() {
        int[] sequence1 = {1, 1, 1};
        int[] sequence2 = {6, 6, 6};

        int player1Wins = 0;
        int player2Wins = 0;
        int ties = 0;

        for (int i = 0; i < N_SIMULATIONS; i++) {
            int[] rolls = new int[N_ROLLS];
            for (int j = 0; j < N_ROLLS; j++) {
                rolls[j] = random.nextInt(6) + 1;
            }

            int player1Score = countEntries(rolls, sequence1);
            int player2Score = countEntries(rolls, sequence2);

            if (player1Score > player2Score) {
                player1Wins++;
            } else if (player2Score > player1Score) {
                player2Wins++;
            } else {
                ties++;
            }
        }

        double player1WinProbability = (double) player1Wins / N_SIMULATIONS;
        double player2WinProbability = (double) player2Wins / N_SIMULATIONS;
        double tieProbability = (double) ties / N_SIMULATIONS;

        System.out.printf("Player 1 win probability: %.4f%n", player1WinProbability);
        System.out.printf("Player 2 win probability: %.4f%n", player2WinProbability);
        System.out.printf("Tie probability: %.4f%n", tieProbability);
    }
}

/*
 Я бы с удовольствием сделал через Stream API, чтобы не забивать массив бросками кубиков,
 а просто получать из IntStream следующее значение, а каждый игрок бы сравнивал и считал свои очки.
 Таким образом можно не создавать массив, а "обход" будет в одну линию,
 но такая реализация показалась мне громоздкой и неуместной для решения алгоритмической задачи.
*/