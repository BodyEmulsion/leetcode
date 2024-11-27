package org.example;

public class Problem2130MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        int n = 0;
        var current = head;
        while (current != null) {
            current = current.next;
            n++;
        }

        n /= 2;
        current = head;
        ListNode next = head.next;
        ListNode previous = null;
        while (n > 1) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
            n--;
        }
        current.next = previous;

        int max = 0;
        int sum;
        while (next != null) {
            sum = current.val + next.val;
            if (sum > max) {
                max = sum;
            }
            current = current.next;
            next = next.next;
        }

        return max;
    }
}
