package Day226;

import java.util.*;

public class FlattningOfLinkedList {
    static class Node {
        Node next;
        Node child;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    static Node vertical(Node head) {
        Node temp = head;
        List<Integer> aa = new ArrayList<>();
        while (temp != null) {
            Node t2 = temp;
            while (t2 != null) {
                aa.add(t2.val);
                t2 = t2.child;
            }
            temp = temp.next;
        }
        if (aa.size() == 0)
            return null;
        Collections.sort(aa);
        head = new Node(aa.get(0));
        temp = head;
        for (int i = 1; i < aa.size(); i++) {
            Node newNode = new Node(aa.get(i));
            temp.child = newNode;
            temp = temp.child;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);

        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next.child = new Node(20);

        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        Node ans = vertical(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.child;
        }
    }

}
