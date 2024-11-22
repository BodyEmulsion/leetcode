package org.example;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Problem2095DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (slow.next == null) {
            return null;
        }
        while (fast.next.next != null) {
            fast = fast.next.next;
            if (fast.next == null) {
                slow.next = slow.next.next;
                return head;
            }
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
