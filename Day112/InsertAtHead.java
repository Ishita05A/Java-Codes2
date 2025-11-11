package Day112;

public class InsertAtHead {
    public static class Node{
        int val;
        Node next;
        
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
    static Node deleteTail(Node head){
        if(head == null) return null;
        if(head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    static boolean findElement(Node head,int data){
        Node temp = head;
        while(temp != null){
            if(temp.val == data) return true;
            temp = temp.next;  
        }
        return false;
    }
    static Node insertAtHead(Node head,int data){
        Node temp = new Node(data);
        if(head == null) return temp;
        temp.next = head;
        head = temp;
        return head;

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        a = insertAtHead(a, 9);
        System.out.println(findLength(a));
        a = deleteTail(a);
        System.out.println(findLength(a));
        display(a);
        System.out.println(findElement(a, 6));
        System.out.println(findElement(a, 8));
    }
    
}
