package Day151;

public class InsertNode {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data  = data;
        }
    }
    static boolean search_element(Node head,int val){
        if(head == null) return false;
        if(head.data == val) return true;
        return search_element(head.next, val);
    }
    static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static int find_length(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    static Node insertAtHead(Node head,Node newNode){
        if(head == null) return newNode;
        newNode.next = head;
        head = newNode;
        return head;
    }
    static Node delete_tail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node  a = new Node(3);
        Node  b = new Node(4);
        Node  c = new Node(7);
        Node  d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        display(a);
        Node g = new Node(5);
        a = insertAtHead(a, g);
        display(a);
        a = delete_tail(a);
        display(a);
        System.out.println(find_length(a));
        System.out.println(search_element(a, 4));
    }
    
}
