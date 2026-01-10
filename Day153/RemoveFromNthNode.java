package Day153;

public class RemoveFromNthNode {
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
    static int findLength(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    static Node removNth(Node head,int k){
        if(head == null) return head;
        int n = findLength(head);
        Node temp = head;
        for(int i = 1;i<n-k;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
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
        display(removNth(a, 3));
    }
    
}
