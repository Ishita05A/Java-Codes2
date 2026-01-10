package Day153;

public class Pallindrome {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data  = data;
        }
    }
    static Node middle(Node head){
        if(head == null) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node after = head;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    static boolean isPallindrome(Node head){
        Node mid = middle(head);
        Node temp1 = head;
        Node temp2 = reverse(mid.next);
        mid.next = null;
        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
           
        }
        return true;
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
        System.out.println(isPallindrome(a));
    }
    
}
