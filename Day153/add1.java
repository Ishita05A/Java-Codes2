package Day153;

public class add1 {
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
    static Node add_1(Node head){
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp != null){
            temp.data = temp.data+carry;
            if(temp.data<10){
                carry = 0;
                break;
            }
            else{
                temp.data = temp.data%10;
            } 
            temp = temp.next;
        }
        head = reverse(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
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
        display(a);
        display(add_1(a));
    }
    
}
