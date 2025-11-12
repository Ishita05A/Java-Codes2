package Day113;

public class ReverseLL_Iterative {
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
    static Node reverseLL(Node head){
        Node temp = null;
        Node newHead = head;
        while(head != null){
             newHead = head.next;
             head.next = temp;
             temp = head;
             head = newHead;
        }
        return temp;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        display(a);
        a = reverseLL(a);
        display(a);
    }
    
}
