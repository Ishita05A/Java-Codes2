package Day98;

public class MinimumNode {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static int minimum(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(root.left.val, root.right.val));
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
        b.right = e;
        c.left = f;
        System.out.println(minimum(root));
    }
    
}
