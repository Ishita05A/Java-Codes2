package Day184;

public class DetectCycle {
    static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void display(Node temp){
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node segregate(Node head){
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while(even != null && evenHead != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    static boolean isCyclic(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    // static Node removeNthNode(Node root){
    //     Node 
    // }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // e.next = b;
        // System.out.println(isCyclic(a));
        Node head = segregate(a);
        display(head);
    }
}
