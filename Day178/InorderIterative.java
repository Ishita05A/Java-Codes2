package Day178;

import java.util.*;
public class InorderIterative {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static class Pair{
        Node node;
        int tm;
        Pair(Node node,int tm){
            this.node = node;
            this.tm = tm;
        }
    }
    static void allTraversal(Node root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair top = st.pop();
            Node node =top.node;
            int tm = top.tm;
            if(tm == 1){
                pre.add(node.val);
                st.push(new Pair(node, tm+1));
                if(node.left != null) st.push(new Pair(node.left, 1));
            }
            else if(tm == 2){
                in.add(node.val);
                st.push(new Pair(node, tm+1));
                if(node.right != null) st.push(new Pair(node.right, 1));
            }
            else{
                post.add(node.val);
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
        
    }
    static void postOrder2(Node root){
        Stack<Node> st = new Stack<>();
        Node node = root;
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty() || node != null){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }
                else node = temp;
            }
        }
        System.out.println(ans);
    }
    static void postOrderIterative(Node root){
        Stack<Node> st = new Stack<>();
        Stack<Node> st1 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            st1.push(top);
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
        }
        while(!st1.isEmpty()){
            ans.add(st1.pop().val);
        }
        System.out.println(ans);

    }
    static void inorder(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        Node node = root;
        while(!st.isEmpty() || node != null){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        System.out.println(ans);
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
        inorder(root);
        postOrderIterative(root);
        postOrder2(root);
        allTraversal(root);
    }
    
}
