package Day113;

public class ReverseDLL {
    public static class Node{
        int val;
        Node next;
        Node prev;
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
    static Node reverse(Node head){
        Node curr = head;
        Node after = head;
        Node before = null;
        while(curr!=null){
            after = curr.next;
            curr.next = before;
            curr.prev = after;
            before= curr;
            curr = after;
        }
        return before;
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(7);
        Node d = new Node(0);
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        display(a);
        a = reverse(a);
        display(a);
        
    }
    
}
