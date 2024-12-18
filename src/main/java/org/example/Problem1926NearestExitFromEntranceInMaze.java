package org.example;

import java.util.ArrayDeque;
import java.util.List;

public class Problem1926NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int stepCounter = 0;
        var possibleSteps = new ArrayDeque<Pair>();

        possibleSteps.add(new Pair(entrance[0], entrance[1]));
        int currentStepPossibilities = 1;

        while (!possibleSteps.isEmpty()) {
            var current = possibleSteps.pop();
            if (isBorder(maze, current) && (current.x != entrance[0] || current.y != entrance[1])) {
                return stepCounter;
            }

            for (var nextStep : List.of(current.stepLeft(), current.stepRight(), current.stepUp(), current.stepDown())) {
                addIfPossible(maze, nextStep, possibleSteps);
            }

            if (--currentStepPossibilities == 0) {
                stepCounter++;
                currentStepPossibilities = possibleSteps.size();
            }
        }
        return -1;
    }

    private void addIfPossible(char[][] maze, Pair possibility, ArrayDeque<Pair> possibleSteps) {
        if (isInsideMaze(maze, possibility) && isPossibleToStep(maze, possibility)) {
            possibility.mark(maze);
            possibleSteps.add(possibility);
        }
    }

    private boolean isPossibleToStep(char[][] maze, Pair step) {
        return step.check(maze) == '.';
    }

    private boolean isInsideMaze(char[][] maze, Pair step) {
        return step.x >= 0 && step.x <= maze.length - 1 && step.y >= 0 && step.y <= maze[0].length - 1;
    }

    private boolean isBorder(char[][] maze, Pair step) {
        return step.x == 0 || step.x == maze.length - 1 || step.y == 0 || step.y == maze[0].length - 1;
    }

    record Pair(int x, int y) {
        char check(char[][] maze) {
            return maze[this.x][this.y];
        }

        void mark(char[][] maze) {
            maze[this.x][this.y] = 'M';
        }

        Pair stepLeft() {
            return new Pair(this.x - 1, this.y);
        }

        Pair stepRight() {
            return new Pair(this.x + 1, this.y);
        }

        Pair stepUp() {
            return new Pair(this.x, this.y - 1);
        }

        Pair stepDown() {
            return new Pair(this.x, this.y + 1);
        }
    }
}
