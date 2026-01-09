package Day152;

public class ReverseaDLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
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
    static void display_reverse(Node head){
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
    }
    static Node reverse_DLL(Node head){
        Node curr = head;
        Node last = null;
        while(curr != null){
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }
        return last;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.prev = a;

        b.next = c;
        c.prev = b;

        c.next = d;
        d.prev = c;
        display(a);
        display_reverse(a);
        display(reverse_DLL(a));
        display_reverse(reverse_DLL(a));
    }
    
}
