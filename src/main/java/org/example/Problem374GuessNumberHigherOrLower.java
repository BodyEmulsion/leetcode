package org.example;

public class Problem374GuessNumberHigherOrLower {
    private int number;

    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        while (true) {
            int pick = (max - min) / 2 + min;
            int guess = guess(pick);
            if (guess > 0) {
                min = pick + 1;
            } else if (guess < 0) {
                max = pick - 1;
            } else {
                return pick;
            }
        }
    }

    private int guess(int pick) {
        return Integer.compare(number, pick);
    }
}
