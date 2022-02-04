package linkedlist;

public class CycleDetection {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        if (head == null) return null;

        while (true) {
           slowPointer = slowPointer.next;
           fastPointer = fastPointer.next;
           if (fastPointer == null || fastPointer.next == null) return null;
           fastPointer = fastPointer.next;
           if (slowPointer == fastPointer) break;
        }

        slowPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return fastPointer;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println(detectCycle(listNode1));
    }
}
