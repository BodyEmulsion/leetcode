package org.example;

public class Problem206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode next;
        while (head.next != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        head.next = previous;
        return head;
    }
}
