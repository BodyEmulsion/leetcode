package org.example;

import java.util.HashSet;
import java.util.Set;

public class Problem1456MaximumNumberOfVowelsInASubstringOfGivenLength {
    private final HashSet<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        int max = count;
        for (int i = 0; i < s.length() - k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count--;
            }
            if (vowels.contains(s.charAt(i + k))) {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
