package Day114;

public class Remove_NthFromBack {
    public static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }
    static int  find_length(Node head){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    static void remove_nth_from_end(Node head,int n){
        Node temp = head;
        int length = find_length(head);
        while(length)
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
    }
    
}
