package Day230;
import java.util.*;

public class AllOrderTraversal {
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
        int time;
        Pair(Node node, int time){
            this.node = node;
            this.time = time;
        }
    }
    static void all_order(Node root){
        if(root == null) return;
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair top = st.pop();
            if(top.time == 1){
                pre.add(top.node.val);
                st.push(new Pair(top.node, 2));
                if(top.node.left != null) st.push(new Pair(top.node.left, 1));
            }
            else if(top.time == 2){
                in.add(top.node.val);
                st.push(new Pair(top.node, 3));
                if(top.node.right != null) st.push(new Pair(top.node.right, 1));
            }
            else{
                post.add(top.node.val);
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
        

    }
    static void inOrder(Node root){
         if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
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
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        all_order(root);
    }
    
}
