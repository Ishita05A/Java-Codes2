package Day112;

public class DoublyLL {
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
    static int findLength(Node head){
        Node temp = head;
        int c = 0;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        return c;
    }
    static Node insert(Node head,int data,int pos){
        Node newNode = new Node(data);
        Node temp = head;
        if(head == null) return newNode;
        if(head.next == null){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        int size = findLength(head);
        if(pos>size+1){
            System.out.println("Position Not Valid");
            return head;
        }
        if(pos == size+1){
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            return head;
        }
        int c = 1;
        temp = head;
        while(c<pos-1){
            temp = temp.next;
            c++;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        // Node b = new Node(4);
        // Node c = new Node(7);
        // Node d = new Node(0);
        // a.next = b;
        // b.prev = a;
        // b.next = c;
        // c.prev = b;
        // c.next = d;
        // d.prev = c;
        a = insert(a, 9, 1);
        display(a);

    }
    
}
