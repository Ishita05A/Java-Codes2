package Day113;

public class DetectALoop {
    public static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isLoopPresent(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(isLoopPresent(a));
    }
    
}
