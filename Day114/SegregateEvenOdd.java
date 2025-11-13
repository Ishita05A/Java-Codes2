package Day114;

public class SegregateEvenOdd {
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
    static Node segregate(Node head){
        Node oddHead = new Node(0);
        Node odd = oddHead;
        Node evenHead  = new Node(0);
        Node even = evenHead;
        Node temp = head;
        while(temp != null){
            if(temp.val % 2 != 0){
                odd.next = temp;
                odd = odd.next;
            }
            else{
                even.next = temp;
                even = even.next;
            }
            temp = temp.next;
        }
        even.next = oddHead.next;
        odd.next = null;
        return evenHead.next;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        Node head = segregate(a);
        display(head);
    }
    
}
