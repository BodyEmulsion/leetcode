package org.example;

import java.util.ArrayDeque;
import java.util.List;

public class Problem994RottingOranges {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        var rottenOranges = new ArrayDeque<Point>();
        int orangesToRot = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Point(i, j));
                }
                if (grid[i][j] == 1) {
                    orangesToRot++;
                }
            }
        }

        int currentMinuteChecks = rottenOranges.size();
        while (!rottenOranges.isEmpty()) {
            var current = rottenOranges.pop();

            for (var nextStep : List.of(current.left(), current.right(), current.up(), current.down())) {
                orangesToRot -= rotIfPossible(grid, nextStep, rottenOranges);
            }

            if (--currentMinuteChecks == 0 && !rottenOranges.isEmpty()) {
                minutes++;
                currentMinuteChecks = rottenOranges.size();
            }
        }

        return orangesToRot == 0 ? minutes : -1;
    }

    private int rotIfPossible(int[][] maze, Point possibility, ArrayDeque<Point> possibleSteps) {
        if (isInBounds(maze, possibility) && isPossibleToRot(maze, possibility)) {
            possibility.rot(maze);
            possibleSteps.add(possibility);
            return 1;
        }
        return 0;
    }

    private boolean isPossibleToRot(int[][] maze, Point step) {
        return step.check(maze) == 1;
    }

    private boolean isInBounds(int[][] grid, Point step) {
        return step.x >= 0 && step.x <= grid.length - 1 && step.y >= 0 && step.y <= grid[0].length - 1;
    }

    record Point(int x, int y) {
        int check(int[][] grid) {
            return grid[this.x][this.y];
        }

        void rot(int[][] grid) {
            grid[this.x][this.y] = 2;
        }

        Point left() {
            return new Point(this.x - 1, this.y);
        }

        Point right() {
            return new Point(this.x + 1, this.y);
        }

        Point up() {
            return new Point(this.x, this.y - 1);
        }

        Point down() {
            return new Point(this.x, this.y + 1);
        }
    }
}
