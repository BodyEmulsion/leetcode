package org.example;

import java.util.*;

public class Problem399EvaluateDivision {

    public static final int DIVIDEND = 0;
    public static final int DIVISOR = 1;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Pair>> divisionsGraph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            divisionsGraph.computeIfAbsent(equation.get(DIVIDEND), key -> new ArrayList<>())
                    .add(new Pair(equation.get(DIVISOR), values[i]));
            divisionsGraph.computeIfAbsent(equation.get(DIVISOR), key -> new ArrayList<>())
                    .add(new Pair(equation.get(DIVIDEND), 1d / values[i]));
        }

        for (int i = 0; i < queries.size(); i++) {
            var marked = new HashSet<String>();
            List<String> query = queries.get(i);
            result[i] = findPathDfs(divisionsGraph, marked, query.get(DIVIDEND), query.get(DIVISOR));
        }
        return result;
    }

    double findPathDfs(Map<String, List<Pair>> divisionsGraph, HashSet<String> marked, String previous, String divisor) {
        if (divisionsGraph.get(previous) == null) {
            return -1;
        }
        for (var path : divisionsGraph.get(previous)) {
            if (Objects.equals(path.to(), divisor)) {
                return path.value();
            }

            if (marked.contains(previous + path.to())) {
                continue;
            }

            marked.add(previous + path.to());
            double pathResult = findPathDfs(divisionsGraph, marked, path.to(), divisor);
            if (pathResult != -1) {
                return pathResult * path.value();
            }
        }
        return -1;
    }
}

record Pair(String to, double value) {
}