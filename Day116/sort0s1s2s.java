package Day116;

public class sort0s1s2s {
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
    static Node sort(Node head){
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;
        Node temp = head;
        while(temp != null){
            if(temp.val == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.val == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;
        if( oneHead.next != null){
            zero.next = oneHead.next;
            one.next = twoHead.next;
        }
        if(oneHead.next == null){
            zero.next = twoHead.next;
        }
        // if(zeroHead.next == null && oneHead.next == null){
        //     zero.next = twoHead.next; 
        // }

        return zeroHead.next;

    }
    public static void main(String[] args) {
         Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        Node head = sort(a);
        display(head);
    }
    
}
