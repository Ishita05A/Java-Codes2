package Day153;

public class sort {
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
    static Node findMiddle(Node head){
        if(head == null) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return head;
    }
    static Node merge(Node head,Node left,Node right){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (left != null && right != null) {
            if(left.data <= right.data){
                temp.next = left;
                left = left.next;
            }
            else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    static Node sort_LL(Node head){
        if(head == null || head.next == null) return head;
        Node left = head;
        Node mid = findMiddle(head);
        Node right = mid.next;
        mid.next = null;
        left = sort_LL(left);
        right = sort_LL(right);
        return merge(head, left, right);


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
        display(sort_LL(a));
    }
    
}
