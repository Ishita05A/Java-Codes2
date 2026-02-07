package Day169;

import java.util.*;
public class BinaryTreeTaversal {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> a = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node top = q.poll();
                if(top.left != null) q.add(top.left);
                if(top.right != null ) q.add(top.right);
                a.add(top.val);
            }
            ans.add(a);
        }
        return ans;
    }
    static void iterativePreOrderTraversal(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node top = st.pop();
            ans.add(top.val);
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
        System.out.println(ans);
    }
    static void iterativeInOrderTraversal(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()){
            if(st.peek().left != null){
                while(st.peek().left != null) st.push(st.peek().left);
            }
            else{
                Node top = st.pop();
                ans.add(top.val);
                if(top.right != null) st.push( top.right);
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
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(levelOrder(root));
        iterativePreOrderTraversal(root);
        iterativeInOrderTraversal(root);

    }
    
}
