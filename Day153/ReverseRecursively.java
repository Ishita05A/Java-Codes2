package Day153;

public class ReverseRecursively {
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
    // static Node reverse_iterative(Node head){
    //     if(head == null || head.next == null) return head;


    // }
    public static void main(String[] args) {
         Node  a = new Node(3);
        Node  b = new Node(4);
        Node  c = new Node(7);
        Node  d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
    }
    
}
