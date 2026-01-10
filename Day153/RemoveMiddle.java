package Day153;

public class RemoveMiddle {
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
    static Node remove_middle(Node head){
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast =fast.next.next;
        }
        slow.next = slow.next.next;
        return head;

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
        display(remove_middle(a));
    }
}
