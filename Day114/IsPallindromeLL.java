package Day114;

public class IsPallindromeLL {
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
    static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        if(head == null) return null;
        if(head.next == null) return head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    static boolean isPallindrome(Node head){
        Node mid = findMiddle(head);
        Node temp1 = head;
        Node temp2 = reverse(mid.next);
        while(temp2 != null && temp1 != null){
            if(temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(5);
        Node d = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
       
        System.out.println(isPallindrome(a));
    }
    
}
