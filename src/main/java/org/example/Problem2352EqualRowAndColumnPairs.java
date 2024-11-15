package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem2352EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        var rows = new HashMap<List<Integer>, Integer>();
        for (var array : grid) {
            List<Integer> row = new ArrayList<>();
            for (int num : array) {
                row.add(num);
            }
            rows.merge(row, 1, Integer::sum);
        }

        int pairs = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> column = new ArrayList<>();
            for (int[] row : grid) {
                column.add(row[i]);
            }
            pairs += rows.getOrDefault(column, 0);
        }
        return pairs;
    }
}
