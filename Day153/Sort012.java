package Day153;

public class Sort012 {
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
    static Node sort(Node head){
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
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
        if(oneHead.next != null){
            zero.next = oneHead.next;
            one.next = twoHead.next;
        }
        else zero.next = twoHead.next;
        return zeroHead.next;

    }
    public static void main(String[] args) {
        Node  a = new Node(0);
        Node  b = new Node(1);
        Node  c = new Node(2);
        Node  d = new Node(1);
        Node  e = new Node(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        display(a);
        display(sort(a));
    }
    
}
