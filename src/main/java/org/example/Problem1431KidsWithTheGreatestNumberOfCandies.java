package org.example;

import java.util.Arrays;
import java.util.List;

public class Problem1431KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxKidCandies = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies)
                .mapToObj(kidCandies -> kidCandies + extraCandies >= maxKidCandies)
                .toList();
    }
}
