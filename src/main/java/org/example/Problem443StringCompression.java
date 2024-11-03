package org.example;

public class Problem443StringCompression {
    public int compress(char[] chars) {
        int size = 0;
        char index = 0;
        while (index < chars.length) {
            char current = chars[index];
            int count = 0;
            chars[size++] = current;

            while (index < chars.length && chars[index] == current) {
                count++;
                index++;
            }

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[size++] = c;
                }
            }
        }
        return size;
    }
}