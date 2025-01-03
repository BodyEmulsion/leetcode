package org.example;

public class Problem1071GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, gcd(str1.length(), str2.length()));
        } else {
            return "";
        }
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
