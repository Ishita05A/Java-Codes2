package Day99;

public class BalancedBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static int height(Node root){
        if(root == null || (root.left != null || root.right != null)) return 0;
        return Math.max(height(root.left), height(root.right));
    }

    static boolean isBalanced(Node root){
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(root.left != null) lh++;
        if(root.right != null) rh++;
        int d = lh-rh;
        if(d<0) d = -d;
        if(d>1) return false; 
        return isBalanced(root.left) && isBalanced(root.right);
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
        System.out.println(isBalanced(root));
    }
    
}
