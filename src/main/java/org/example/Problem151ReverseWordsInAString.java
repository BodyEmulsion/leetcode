package org.example;

public class Problem151ReverseWordsInAString {
    public String reverseWords(String s) {
        var result = new StringBuilder();
        int wordStart;
        int wordEnd;
        int i = s.length() - 1;
        while (i >= 0) {
            while (i > 0 && s.charAt(i) == ' ') {
                i--;
            }
            wordEnd = i + 1;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            wordStart = i + 1;
            result.append(s, wordStart, wordEnd);
            result.append(' ');
            i--;
        }
        return result.toString().trim();
    }
}
