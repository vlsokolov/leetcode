package linkedlist;

import java.util.List;

public class ReversedLinkedListII {

    public static class ListNode {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newList = null;
        ListNode current = head;
        ListNode start = head;
        int index = 1;

        while (index < left) {
            start = current;
            current = current.next;
            index++;
        }

        ListNode tail = current;

        while (index >= left && index <= right) {
            ListNode next = current.next;
            current.next = newList;
            newList = current;
            current = next;
            index++;
        }

        start.next = newList;
        tail.next = current;

        if (left > 1) {
            return head;
        } else {
            return newList;
        }
    }


    public static void main(String[] args) {
        ListNode t = reverseBetween(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 2, 4
        );
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }
}
