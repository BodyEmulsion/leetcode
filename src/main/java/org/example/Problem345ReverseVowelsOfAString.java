package org.example;

import java.util.Set;

public class Problem345ReverseVowelsOfAString {
    private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int left = 0;
        int right = word.length - 1;
        while (left < right) {
            if (!vowels.contains(word[left])) {
                left++;
            } else if (!vowels.contains(word[right])) {
                right--;
            } else {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                left++;
                right--;
            }
        }
        return new String(word);
    }
}
