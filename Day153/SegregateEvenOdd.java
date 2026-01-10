package Day153;

public class SegregateEvenOdd {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data  = data;
        }
    }
    static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node evenOdd(Node head){
        Node evenHead = new Node(-1);
        Node even = evenHead;
        Node oddHead = new Node(-1);
        Node odd = oddHead;
        Node temp = head;
        while(temp != null){
            if(temp.data %2 == 0){
                even.next = temp;
                even = even.next;
            }
            else{
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        odd.next = null;
        even.next = oddHead.next;
        return evenHead.next;
    }
    public static void main(String[] args) {
        Node  a = new Node(1);
        Node  b = new Node(2);
        Node  c = new Node(3);
        Node  d = new Node(2);
        Node  e = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        display(a);
        display(evenOdd(a));

    }
    
}
