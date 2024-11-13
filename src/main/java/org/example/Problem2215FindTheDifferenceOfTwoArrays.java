package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem2215FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var firstNumbers = new HashSet<Integer>();
        for (var num : nums1) {
            firstNumbers.add(num);
        }
        var secondNumbers = new HashSet<Integer>();
        for (var num : nums2) {
            secondNumbers.add(num);
        }

        List<List<Integer>> result = List.of(new ArrayList<>(), new ArrayList<>());
        for (var num : firstNumbers) {
            if (!secondNumbers.contains(num)) {
                result.get(0).add(num);
            }
        }
        for (var num : secondNumbers) {
            if (!firstNumbers.contains(num)) {
                result.get(1).add(num);
            }
        }
        return result;
    }
}
