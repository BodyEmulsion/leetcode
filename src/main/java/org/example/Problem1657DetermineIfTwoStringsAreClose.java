package org.example;

import java.util.Arrays;

public class Problem1657DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(new Problem1657DetermineIfTwoStringsAreClose().closeStrings("cabbba", "abbccc"));
    }

    public boolean closeStrings(String word1, String word2) {
        var signature1 = getWordSignature(word1);
        var signature2 = getWordSignature(word2);
        return signature1.length == signature2.length
                && containsSameChars(signature1, signature2)
                && sameCharCounts(signature1, signature2);


    }

    private static boolean containsSameChars(int[] signature1, int[] signature2) {
        for (int i = 0; i < signature1.length; i++) {
            if (signature1[i] != 0 && signature2[i] == 0
                    || signature1[i] == 0 && signature2[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean sameCharCounts(int[] signature1, int[] signature2) {
        Arrays.sort(signature1);
        Arrays.sort(signature2);
        return Arrays.equals(signature1, signature2);
    }

    private static int[] getWordSignature(String word) {
        var signature = new int[26];
        for (char character : word.toCharArray()) {
            signature[character - 'a']++;
        }
        return signature;
    }
}
