package Day136;

import java.util.Stack;

public class TwoSumInBST {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    private static Stack<Node> st = new Stack<>();
    private static Stack<Node> gt = new Stack<>();
    static void pushAll(Node root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    static int next(){
        Node top = st.pop();
        pushAll(top.right);
        return top.val;
    }
    static void bstNextIterator(Node root){
        pushAll(root);
    }
// for before....
    static void push(Node root){
        while(root != null){
            gt.push(root);
            root = root.right;
        }
    }
    static int before(){
        Node top = gt.pop();
        push(top.left);
        return top.val;
    }
    static void bstBeforeIterator(Node root){
        push(root);
    }

    static boolean twosum(Node root,int k){
        if(root == null) return false;
        bstBeforeIterator(root);
        bstNextIterator(root);
        int num1 = next();
        int num2 = before();
        while(num1<num2){
            int sum = num1+num2;
            if(sum == k) return true;
            else if(sum<k) num1 = next();
            else num2 = before();
        }
        return false;
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
        System.out.println(twosum(root, 21));
    }
    
}
