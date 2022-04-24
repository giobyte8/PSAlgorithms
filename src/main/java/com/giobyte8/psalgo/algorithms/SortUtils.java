package com.giobyte8.psalgo.algorithms;

class SortUtils {

    public static <T> void swap(int[] elements, int pos1, int pos2) {
        int aux = elements[pos1];
        elements[pos1] = elements[pos2];
        elements[pos2] = aux;
    }

    public static <T> void swap(T[] elements, int pos1, int pos2) {
        T aux = elements[pos1];
        elements[pos1] = elements[pos2];
        elements[pos2] = aux;
    }
}
