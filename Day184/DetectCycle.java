package Day184;

public class DetectCycle {
    static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
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
        System.out.println(isCyclic(a));
    }
}
