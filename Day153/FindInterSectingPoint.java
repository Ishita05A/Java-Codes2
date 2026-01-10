package Day153;

public class FindInterSectingPoint {
     static class Node{
        int data;
        Node next;
        Node(int data){
            this.data  = data;
        }
    }
    static int countNode(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    static Node find_collision(Node head1,Node head2,int n){
        Node temp1 = head1;
        Node temp2 = head2;
        for(int i = 1;i<=n;i++){
            temp2 = temp2.next;
        }
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
    static Node findIntersectingPoint(Node head1,Node head2){
        int n1 = countNode(head1);
        int n2 = countNode(head2);
        if(n1>n2){
            return find_collision(head2, head1, n1-n2);
        }
        else{
            return find_collision(head1, head2, n2-n1);
        }
        // return find_collision(head1, head2, 0);
    }
    public static void main(String[] args) {
         Node  a = new Node(9);
        Node  b = new Node(9);
        Node  c = new Node(9);
        Node  d = new Node(4);
        Node  e = new Node(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node w = new Node(4);
        Node  x = new Node(9);
        Node  y= new Node(9);
        Node  z = new Node(9);
        w.next = x;
        x.next = y;
        y.next = z;
        z.next = d;
        System.out.println(findIntersectingPoint(a, x).data);
    }
    
}
