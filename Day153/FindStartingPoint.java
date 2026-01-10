package Day153;

public class FindStartingPoint {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data  = data;
        }
    }
    static int findStartingPoint(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return -1;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
    public static void main(String[] args) {
        Node  a = new Node(3);
        Node  b = new Node(4);
        Node  c = new Node(7);
        Node  d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(findStartingPoint(a));
        
    }
    
}
