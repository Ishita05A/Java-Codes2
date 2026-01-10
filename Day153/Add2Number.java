package Day153;

public class Add2Number {
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
    static Node add2Number(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummyNode  = new Node(-1);
        Node temp = dummyNode;
        int carry = 0;
        while(temp1 != null || temp2 != null){
    
            int val = carry;
            if(temp1 != null){
                 val+=temp1.data;
                 temp1 = temp1.next;
            }
            if(temp2 != null){
                 val+=temp2.data;
                 temp2 = temp2.next;
            }
            Node newNode = new Node(val);
            if(val <10){
                temp.next = newNode;
                temp = temp.next;
            }
            else{
                newNode.data = val%10;
                carry = val/10;
                temp.next = newNode;
                temp = temp.next;
            }
           
        }
        if(carry >0){
            Node newNode = new Node(carry);
            temp.next = newNode;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
         Node  a = new Node(9);
        Node  b = new Node(9);
        Node  c = new Node(9);
        Node  d = new Node(9);
        Node  e = new Node(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node  x = new Node(9);
        Node  y= new Node(9);
        Node  z = new Node(9);
        x.next = y;
        y.next = z;
        display(a);
        display(x);
        display(add2Number(a, x));
    }
    
}
