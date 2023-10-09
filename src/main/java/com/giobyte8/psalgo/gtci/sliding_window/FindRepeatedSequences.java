package com.giobyte8.psalgo.gtci.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequences {

    public static Set<String> findRepeatedSequences(String s, int k) {
        Set<String> seqs = new HashSet<>();
        Set<String> repeatedSeqs = new HashSet<>();

        if (s.length() <= k)
            return repeatedSeqs;

        int wStart = 0;
        int wEnd = k;

        while (wEnd <= s.length()) {
            String seq = s.substring(wStart, wEnd);

            // If addition to seqs fails (Already exists) then add it to
            // duplicated sequences set
            if (!seqs.add(seq)) {
                repeatedSeqs.add(seq);
            }

            wStart++;
            wEnd++;
        }

        return repeatedSeqs;
    }
}
