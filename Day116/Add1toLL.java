package Day116;

public class Add1toLL {
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
    static Node reverse(Node head){
        if(head.next == null || head == null ) return head;
        Node curr = head;
        Node after = head;
        Node before = null;
        while(curr != null){
            after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;

        }
        return before;
    }
    static Node add_1(Node head){
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp != null){
            temp.val = temp.val+ carry;
            if(temp.val <10){
                carry = 0;
                break;
            }
            else{
                temp.val = 0;
            }
            temp = temp.next;
        }
        head = reverse(head);
        if(carry == 1){
            Node newHead  = new Node(1);
            newHead.next =head;
            return newHead;
        }
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(9);
        Node b = new Node(9);
        Node c = new Node(9);
        Node d = new Node(9);
        a.next = b;
        b.next = c;
        c.next = d;
        Node head = add_1(a);
        display(head);

    }
    
}
