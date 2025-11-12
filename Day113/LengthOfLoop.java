package Day113;

public class LengthOfLoop {
    public static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }
    static int length_of_loop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        int length = 0;
        do{
            fast = fast.next;
            length++;
        }
        while(slow != fast);
        return length;
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
        System.out.println(length_of_loop(a));
        
    }
    
}
