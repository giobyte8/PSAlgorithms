package com.giobyte8.psalgo;

import java.util.ArrayDeque;

public class Utils {

    public static int[] toDigits(int n) {
        ArrayDeque<Integer> digits = new ArrayDeque<>();
        while (n > 0) {
            digits.push(n % 10);
            n = n / 10;
        }

        return digits.stream().mapToInt(i -> i).toArray();
    }
}
