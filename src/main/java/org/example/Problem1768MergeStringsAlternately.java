package org.example;

public class Problem1768MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        var result = new StringBuilder();
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
            if (word1.length() > i) {
                result.append(word1.charAt(i));
            }
            if (word2.length() > i) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}
