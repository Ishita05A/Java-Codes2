package Day116;

public class FindIntersection {
    public static class Node{
        int val;
        Node next;
        
        Node(int val){
            this.val = val;
        }
    }
    static int find_length(Node head){
        Node temp = head;
        int c = 0;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        return c;
    }
    static Node find_intersection(Node head1, Node head2){
        int len1 = find_length(head1);
        int len2 = find_length(head2);
        int diff = len1 - len2;
        if(diff <0) diff = -diff;
        Node temp1 = head1;
        Node temp2 = head2;
        if(len1 > len2){
            while(diff>0){
                temp1 = temp1.next;
                diff--;
            }
        } 
        else if(len2 > len1){
                while(diff>0){
                    temp2 = temp2.next;
                    diff--;
                }
            
        }
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return null;

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node f = new Node(3);
        f.next = d;
        Node intersection = find_intersection(a, f);
        if(intersection != null) System.out.println(intersection.val);
        else System.out.println("null");


    }
    
}
