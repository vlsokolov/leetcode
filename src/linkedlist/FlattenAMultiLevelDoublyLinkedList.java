package linkedlist;

public class FlattenAMultiLevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

    }

    public Node flatten(Node head) {
        Node current = head;

        while (current != null) {
            if (current.child == null) {
                current = current.next;
            } else {
                Node child = current.child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next = current.next;
                if (child.next != null) {
                    child.next.prev = child;
                }

                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        FlattenAMultiLevelDoublyLinkedList f = new FlattenAMultiLevelDoublyLinkedList();

        Node node7 = new Node(7, null, null, null);
        Node node8 = new Node(8, node7, null, null);
        Node node9 = new Node(9, node8, null, null);
        Node node10 = new Node(10, node9, null, null);
        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, node11, null, null);
        Node node3 = new Node(3, null, null, node7);
        Node node2 = new Node(2, null, node3, null);
        Node node1 = new Node(1, null, node2, null);
        Node node4 = new Node(4, node3, null, null);
        Node node5 = new Node(5, node4, null, null);
        Node node6 = new Node(6, node5, null, null);

        node2.prev = node1;
        node3.prev = node2;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node8.child = node11;
        node11.next = node12;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;
        node8.next = node9;
        node3.next = node4;

        Node result = f.flatten(node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
