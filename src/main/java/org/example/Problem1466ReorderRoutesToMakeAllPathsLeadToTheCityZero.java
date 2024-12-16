package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public static final int TO = 0;
    public static final int FROM = 1;

    public int minReorder(int n, int[][] connections) {
        var map = new HashMap<Integer, List<List<Integer>>>();
        for (var connection : connections) {
            map.computeIfAbsent(connection[0], key -> new ArrayList<>()).add(List.of(connection[1], TO));
            map.computeIfAbsent(connection[1], key -> new ArrayList<>()).add(List.of(connection[0], FROM));
        }
        return dfs(0, -1, map);
    }

    private int dfs(int node, int previousNode, HashMap<Integer, List<List<Integer>>> map) {
        var connections = map.get(node);
        int count = 0;
        for (var connection : connections) {
            if (connection.get(0) == previousNode) {
                continue;
            }
            if (connection.get(1) == TO) {
                count += dfs(connection.get(0), node, map) + 1;
            } else {
                count += dfs(connection.get(0), node, map);
            }
        }
        return count;
    }

}
