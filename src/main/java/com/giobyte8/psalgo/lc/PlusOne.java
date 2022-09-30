package com.giobyte8.psalgo.lc;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            digits[i] = 0;
            if (i == 0) {
                return add1ToLeftSide(digits);
            }
        }

        return digits;
    }

    private int[] add1ToLeftSide(int[] digits) {
        int[] resizedDigits = new int[digits.length + 1];
        resizedDigits[0] = 1;

        for (int i = 0; i < digits.length; i++) {
            resizedDigits[i+1] = digits[i];
        }

        return resizedDigits;
    }
}
