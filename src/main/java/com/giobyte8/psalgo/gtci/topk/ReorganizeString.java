package com.giobyte8.psalgo.gtci.topk;

import java.util.*;

public class ReorganizeString {

    public static String reorganizeString(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }

        Comparator<Map.Entry<Character, Integer>> freqsComparator =
                (freq1, freq2) -> freq2.getValue().compareTo(freq1.getValue());
        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<>(freqsComparator);
        pq.addAll(freqs.entrySet());

        StringBuilder resultBuilder = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> freq1 = pq.poll();

            // Just 1 char available for consumption
            if (pq.isEmpty()) {
                if (freq1.getValue() > 1)
                    return "";
                resultBuilder.append(freq1.getKey());
            } else {
                Map.Entry<Character, Integer> freq2 = pq.poll();

                // Consume all freq from both chars?
                if (freq1.getValue().equals(freq2.getValue())) {
                    for (int i = 0; i < freq1.getValue(); i++) {
                        resultBuilder.append(freq1.getKey()).append(freq2.getKey());
                    }
                }

                // Consume from freq1 as many times as freq2 exists
                else {
                    for (int i = 0; i < freq2.getValue(); i++) {
                        resultBuilder.append(freq1.getKey()).append(freq2.getKey());
                    }

                    freq1.setValue(freq1.getValue() - freq2.getValue());
                    pq.offer(freq1);
                }
            }
        }

        return resultBuilder.toString();
    }
}
