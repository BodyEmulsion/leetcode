package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem649Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> dires = new ArrayDeque<>();
        Queue<Integer> radiants = new ArrayDeque<>();
        char[] senators = senate.toCharArray();
        for (int i = 0; i < senators.length; i++) {
            if (senators[i] == 'D') {
                dires.add(i);
            } else {
                radiants.add(i);
            }
        }

        int lastPosition = senators.length;
        while (!dires.isEmpty() && !radiants.isEmpty()) {
            if (dires.peek() > radiants.peek()) {
                dires.poll();
                radiants.add(radiants.poll() + lastPosition++);
            } else {
                radiants.poll();
                dires.add(dires.poll() + lastPosition++);
            }
        }

        char winner = radiants.isEmpty() ? 'D' : 'R';
        return winner == 'D' ? "Dire" : "Radiant";
    }
}
