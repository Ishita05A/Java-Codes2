package Day116;

public class sortLL {
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
    static Node find_middle(Node head){
        if(head.next == null || head == null )return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right){
        Node head = new Node(-1);
        Node temp = head;
        while(left != null && right != null){
            if(left.val <= right.val){
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
        return head.next;
    }
    static Node merge_sort(Node head){
        if(head.next == null || head == null ) return head;
        Node mid = find_middle(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        left = merge_sort(left);
        right = merge_sort(right);
        return merge(left, right);

        
    }
    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(9);
        Node c = new Node(2);
        Node d = new Node(0);
        a.next = b;
        b.next = c;
        c.next = d;
        Node head = merge_sort(a);
        display(head);
    }
    
}
