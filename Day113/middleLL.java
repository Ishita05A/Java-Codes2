package Day113;

public class middleLL {
    public static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }
    static Node findLeftMiddle(Node head){
        if(head == null ) return null;
        if(head.next == null ) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
    static Node findMiddleRight(Node head){
        
        Node slow = head;
        Node fast = head;
        
        while(fast!= null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(findMiddleRight(a).val);
        System.out.println(findLeftMiddle(a).val);
    }
    
}
