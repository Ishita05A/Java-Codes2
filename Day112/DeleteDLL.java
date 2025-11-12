package Day112;

public class DeleteDLL {
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
    static Node delete(Node head, int pos){
        if(head==null) return null;
        if(head.next == null) return null;
        int size = findLength(head);
        Node temp = head;
        if(pos == 1) return head.next;
        int c = 1;
        if(pos<size){
            while(c<pos-1){
                temp = temp.next;
                c++;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
            return head;
        }
        
        if(pos == size){
            temp = head;
            while (temp.next.next != null)  temp = temp.next;
            temp.next = null;
            return head;
        }
        if(pos>size) System.out.println("Position not valid");
        return head;
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
        a = delete(a, 5);
        display(a);
    }
    
}
