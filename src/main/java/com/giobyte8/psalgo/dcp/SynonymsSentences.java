package com.giobyte8.psalgo.dcp;

import java.util.*;

/**
 * This problem was asked by Google.
 * <br/>
 *
 * You are given a set of synonyms, such as (big, large) and (eat, consume).
 * Using this set, determine if two sentences with the same number of words
 * are equivalent.
 * <br/>
 *
 * For example, the following two sentences are equivalent:
 * <br/>
 *
 * "He wants to eat food."
 * "He wants to consume food."
 * </br>
 *
 * Note that the synonyms (a, b) and (a, c) do not necessarily imply (b, c):
 * consider the case of (coach, bus) and (coach, teacher).
 *
 * Follow-up: what if we can assume that (a, b) and (a, c) do in fact imply (b, c)?
 * // TODO Verify solution
 */
public class SynonymsSentences {

    public static boolean areEquivalent(String s1, String s2, String[] synonyms) {

        // Assuming synonyms are provided in pairs like:
        // [a, b, c, d, e, f] = [(a, b), (c, d), (e, f)
        // then create hashmap for quickly findings
        if (synonyms.length % 2 != 0) return false;

        Map<String, Set<String>> hmSynonyms =
                new HashMap<>(synonyms.length / 2);
        for (int i = 0; i <= synonyms.length - 2; i+=2) {
            Set<String> synonyms1 = hmSynonyms.getOrDefault(synonyms[i], new HashSet<>());
            Set<String> synonyms2 = hmSynonyms.getOrDefault(synonyms[i + 1], new HashSet<>());

            synonyms1.add(synonyms[i + 1]);
            synonyms2.add(synonyms[i]);

            hmSynonyms.put(synonyms[i], synonyms1);
            hmSynonyms.put(synonyms[i + 1], synonyms2);
        }

        // Split sentences into words
        String[] s1Words = s1.trim().split(" ");
        String[] s2Words = s2.trim().split(" ");

        // Compare sentences
        for (int i = 0; i < s1Words.length; i++) {
            if (!s1Words[i].equals(s2Words[i]) &&
                    !hmSynonyms.get(s1Words[i]).contains(s2Words[i])) {
                return false;
            }
        }

        return true;
    }
}
