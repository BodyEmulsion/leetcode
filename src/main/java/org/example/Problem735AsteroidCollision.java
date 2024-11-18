package org.example;

import java.util.Stack;

public class Problem735AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new Stack<Integer>();
        int i = 0;
        while (i < asteroids.length) {
            if (stack.isEmpty() || asteroids[i] > 0 || stack.getLast() < 0) {
                stack.add(asteroids[i]);
                i++;
            } else {
                int collisionResult = stack.getLast() + asteroids[i];
                if (collisionResult >= 0) {
                    i++;
                }
                if (collisionResult <= 0) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int j = result.length - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return result;
    }
}