package org.example;

import java.util.LinkedList;

public class Problem2390RemovingStarsFromAString {
    public String removeStars(String s) {
        var stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        var result = new StringBuilder();
        for (char c : stack.reversed()) {
            result.append(c);
        }
        return result.toString();
    }
}
