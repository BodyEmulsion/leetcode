package org.example;

import java.util.Stack;

public class Problem394DecodeString {
    public String decodeString(String s) {
        var repeats = new Stack<Integer>();
        var substrings = new Stack<StringBuilder>();
        var currentRepeat = new StringBuilder();
        var currentString = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentRepeat.append(c);
            } else if (c == '[') {
                repeats.add(Integer.valueOf(currentRepeat.toString()));
                currentRepeat = new StringBuilder();

                substrings.add(currentString);
                currentString = new StringBuilder();
            } else if (Character.isAlphabetic(c)) {
                currentString.append(c);
            } else if (c == ']') {
                var previousString = substrings.pop();
                previousString.repeat(currentString, repeats.pop());
                currentString = previousString;
            }
        }
        return currentString.toString();
    }
}