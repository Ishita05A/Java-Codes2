package Day207;

import java.util.Stack;

public class AllTraversal {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static void levelOrder(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            int size = st.size();
            for(int i = 0;i<size;i++){
                Node top = st.pop();
                System.out.print(top.val+" ");
                if(top.right != null) st.push(top.right); 
                if(top.left != null) st.push(top.left);
            }
            System.out.println();
        }
    }
    static void inOrder_iterative(Node root){
        Node node = root;
        Stack<Node> st = new Stack<>();
        while(!st.empty() || node != null){
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
    static void inOrder(Node root){
        if(root.left != null) inOrder(root.left);
        System.out.print(root.val+" ");
        if(root.right != null) inOrder(root.right);
    }
    static void preOrder_Iterative(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            System.out.print(top.val+" ");
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
    }
    static void preOrder(Node root){
        System.out.print(root.val+" ");
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }
    static void postOrder_1Stack(Node root){
        Stack<Node> st = new Stack<>();
        Node node = root;
        while (!st.isEmpty() || node != null) {
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    System.out.print(temp.val+" ");
                    while(!st.isEmpty() &&  temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.val+" ");
                    }
                }
                else node = temp;
            }
        }
    }
    static void postorder_Iterative(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        Stack<Node> gt = new Stack<>();
        while(!st.isEmpty()){
            Node top = st.pop();
            gt.push(top);
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
        }
        while(!gt.isEmpty()){
            System.out.print(gt.pop().val+" ");
        }
    }
    static void postorder(Node root){
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        System.out.print(root.val+" ");
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
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelOrder(root);
        inOrder_iterative(root);
        System.out.println();
        preOrder_Iterative(root);
        System.out.println();
        postorder_Iterative(root);
        System.out.println();
        postOrder_1Stack(root);

    }
    
}
