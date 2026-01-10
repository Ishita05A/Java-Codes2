package Day153;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void iterative_preOrder(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            System.out.print(top.val+" ");
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
    }
    static void iterative_inorder(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                System.out.print(node.val+" ");
                node = node.right;
            }
        }
    }
    static void iterative_postOrder(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        Stack<Node> st1 = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            st1.push(top);
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
        }
        while(!st1.isEmpty()){
            Node top = st1.pop();
            System.out.print(top.val+" ");
        }
    }
    static void iterative_postOrder_1stack(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    System.out.print(temp.val+" ");
                    while(!st.empty() && temp == st.peek().right){
                        temp= st.pop();
                        System.out.print(temp.val+" ");
                    }

                }
                else curr = temp;
            }
        }
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    static void bfs(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                Node top = q.poll();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                size--;
                System.out.print(top.val+" ");
            }
        }
    }
    static void level_order_1(Node root,int n){
        if(root == null) return;
        if(n == 1) System.out.print(root.val+" "); 
        level_order(root.right, n-1);
        level_order(root.left, n-1);
    }
    static void level_order(Node root,int n){
        if(root == null) return;
        if(n == 1) System.out.print(root.val+" "); 
        level_order(root.left, n-1);
        level_order(root.right, n-1);
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+ Math.max(height(root.left), height(root.right));
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
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        bfs(root);
        System.out.println();
        int height = height(root);
        for(int i = 1;i<=height;i++){
            if(i%2 != 0) level_order(root, i);
            else level_order_1(root, i);
        }
        System.out.println();
        iterative_preOrder(root);
        System.out.println();
        iterative_inorder(root);
        System.out.println();
        iterative_postOrder(root);
        System.out.println();
        iterative_postOrder_1stack(root);


    }
    
}
