package Day153;

public class RemoveDuplicateFromSortedDLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
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
    static Node removeDuplicates(Node head){
        Node temp = head;
        Node nextNode = head.next;
        while(nextNode != null){
            if(nextNode.data != temp.data){
                temp.next = nextNode;
            }
            nextNode = nextNode.next;
        }
        if(temp == head) head.next = null;
        return head;
    }
    public static void main(String[] args) {
         Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(2);

        a.next = b;
        b.prev = a;

        b.next = c;
        c.prev = b;

        c.next = d;
        d.prev = c;
        display(removeDuplicates(a));

    }
    
}
