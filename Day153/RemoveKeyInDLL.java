package Day153;

public class RemoveKeyInDLL {
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
    static Node removeKey(Node head,int k){
        Node temp = head;
        while(temp != null){

            if(temp.data == k){
                if(temp == head) head = head.next;
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if(nextNode != null) nextNode.prev = prevNode;
                if(prevNode != null) prevNode.next = nextNode;
                temp = temp.next;
            }
            else temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(10);
        Node c = new Node(3);
        Node d = new Node(10);

        a.next = b;
        b.prev = a;

        b.next = c;
        c.prev = b;

        c.next = d;
        d.prev = c;
        display(a);
        display(removeKey(a, 10));
        
    }
    
}
