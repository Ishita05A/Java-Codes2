package Day84;


public class ImplementStackUsingLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class Stack {
        Node head = null;
        Node tail = null;
        int size = 0;


        void push(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        int pop() {
            if (size == 0) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int ans = head.data;
            head = head.next;
            size--;
            return ans;
        }

        int peek() {
            if (size == 0) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return head.data;
        }

        boolean isEmpty() {
            return size == 0;
        }
        Node reverse(Node head){
            Node curr = head;
            Node prev = null;
            Node after = null;
            while(curr!=null){
                after = curr.next;
                curr.next = prev;
                prev = curr;
                curr = after;
            }
            return prev;
        }
        void display() {
            head = reverse(head);
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Stack st = new Stack();
        
        st.push(5);
        st.push(7);
        st.push(8);
        st.push(0);
        st.push(1);
        st.display();
        st.push(8);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.size);
    }

}
