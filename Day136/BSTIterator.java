package Day136;

import java.util.Stack;

public class BSTIterator {
     public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    private static Stack<Node> st = new Stack<>();
    static void pushAll(Node root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    static void bstiterator(Node root){
        pushAll(root);
    }
    static int next(){
        Node top = st.pop();
        pushAll(top.right);
        return top.val;
    }
    static boolean hasNext(){
        return !st.isEmpty();
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        Node a = new Node(5);
        Node b = new Node(12);
        Node c = new Node(4);
        Node d = new Node(7);
        Node e = new Node(10);
        Node f = new Node(14);
        Node g = new Node(6);
        Node h = new Node(13);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        f.left = h;
        bstiterator(root);
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(hasNext());
        System.out.println(next());
        
    }
    
}
