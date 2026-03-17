package Day198;

public class DoublyLinkedList {
    static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }
    static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

    static void reverseDisplay(Node tail){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.prev;
        }
    }
    static Node insertAtTail(Node head,Node x){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = x;
        x.prev = temp;
        return head;
    }
    static Node deleteHead(Node head){
        if(head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        // Node d = new Node(2);
        // Node e = new Node(2);
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        Node x =  new Node(6);
        Node head = insertAtTail(a, x);
        display(head);
        System.out.println();
        reverseDisplay(x);


    
    }
    
}
