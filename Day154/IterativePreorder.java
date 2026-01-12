package Day154;

import java.util.Stack;

public class IterativePreorder {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void iterativePreorder(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
            System.out.print(top.val+" ");
        }
    }
    static void iterative_inOrder(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        Node node = root;
        while(node != null || !st.isEmpty()){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                Node top = st.pop();
                System.out.print(top.val+" ");
                node = top.right;
            }
        }
    
    }
    static void iterative_post_order(Node root){
        Stack<Node> st = new Stack<>();
        Stack<Node> st1 = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
            st1.push(top);
        }
        while(!st1.isEmpty()){
            Node top = st1.pop();
            System.out.print(top.val+" ");
        }
    }
    static void iterative_post_order_1stack(Node root){
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr!= null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node node = st.peek().right;
                if(node == null){
                    Node temp = st.pop();
                    System.out.print(temp.val+" ");
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.val+" ");
                    }
                }
                else curr = node;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        iterativePreorder(root);
        System.out.println();
        iterative_inOrder(root);
        System.out.println();
        iterative_post_order(root);
        System.out.println();
        iterative_post_order_1stack(root);
    }
    
}
