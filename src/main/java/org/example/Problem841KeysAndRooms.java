package org.example;

import java.util.*;

public class Problem841KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> reachableRooms = new HashSet<>(rooms.get(0));
        reachableRooms.add(0);
        Queue<Integer> roomsToReach = new ArrayDeque<>(rooms.get(0));
        while (!roomsToReach.isEmpty() && reachableRooms.size() < rooms.size()) {
            var roomKeys = rooms.get(roomsToReach.poll());
            for (var key : roomKeys) {
                if (reachableRooms.add(key)) {
                    roomsToReach.add(key);
                }
            }
        }
        return rooms.size() == reachableRooms.size();
    }

//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        boolean[] reachableRooms = new boolean[rooms.size()];
//        reachableRooms[0] = true;
//        for (var key : rooms.getFirst()) {
//            reachableRooms[key] = true;
//        }
//        Queue<Integer> roomsToReach = new ArrayDeque<>(rooms.get(0));
//
//        while (!roomsToReach.isEmpty()) {
//            var roomKeys = rooms.get(roomsToReach.poll());
//            for (var key: roomKeys) {
//                if (!reachableRooms[key]) {
//                    reachableRooms[key] = true;
//                    roomsToReach.add(key);
//                }
//            }
//        }
//
//        for (var reachable : reachableRooms) {
//            if (!reachable) {
//                return false;
//            }
//        }
//        return true;
//    }
}
