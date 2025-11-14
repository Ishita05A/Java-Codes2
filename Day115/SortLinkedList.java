package Day115;

public class SortLinkedList {
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
    static Node sort0s1s2s(Node head){
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;
        Node temp = head;
        if(head == null) return null;
        while(temp != null){
            if(temp.val == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.val ==1){
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
                
                
            }
            temp = temp.next;
        }
        two.next = null;
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        return zero.next != null ? zeroHead.next : oneHead.next != null ? oneHead.next : twoHead.next;


    }
    public static void main(String[] args) {
         Node a = new Node(0);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(0);
        a.next = b;
        b.next = c;
        c.next = d;
        Node head = sort0s1s2s(a);
        display(head);
    }
    
}
