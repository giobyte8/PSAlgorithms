package com.giobyte8.psalgo.gtci;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm to collect fruits. The farm has a single row of
 * fruit trees. You will be given two baskets, and your goal is to pick as
 * many fruits as possible to be placed in the given baskets.
 *
 * You will be given an array of characters where each character represents
 * a fruit tree. The farm has the following restrictions:
 *
 * Each basket can have only one type of fruit. There is no limit to how many
 * fruit a basket can hold.
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick exactly one fruit from every tree until you cannot, i.e.,you
 * will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both baskets.
 *
 *
 * Example 1:
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from
 * the subarray ['C', 'A', 'C']
 *
 * Example 2:
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class FruitBaskets {

    public static int findLength(char[] arr) {
        Map<Character, Integer> treeOccurrences = new HashMap<>();
        int maxFruitCount = 0;

        char fruit1 = 0;
        char fruit2 = 0;
        for (char fruit : arr) {
            if (fruit1 == 0) {
                fruit1 = fruit;
                addOccurrence(treeOccurrences, fruit1);
            } else if (fruit1 == fruit) {
                addOccurrence(treeOccurrences, fruit1);
            }

            else if (fruit2 == 0) {
                fruit2 = fruit;
                addOccurrence(treeOccurrences, fruit2);
            } else if (fruit2 == fruit) {
                addOccurrence(treeOccurrences, fruit2);
            }

            else {
                int sum = treeOccurrences.get(fruit1) + treeOccurrences.get(fruit2);
                maxFruitCount = Math.max(maxFruitCount, sum);

                treeOccurrences.remove(fruit1);
                fruit1 = fruit2;
                fruit2 = fruit;
                addOccurrence(treeOccurrences, fruit2);
            }
        }

        int sum = treeOccurrences.get(fruit1) + treeOccurrences.get(fruit2);
        return Math.max(maxFruitCount, sum);
    }

    private static void addOccurrence(Map<Character, Integer> treeOccurrences,
                                     Character tree) {
        treeOccurrences.put(
                tree,
                treeOccurrences.getOrDefault(tree, 0) + 1
        );
    }
}
