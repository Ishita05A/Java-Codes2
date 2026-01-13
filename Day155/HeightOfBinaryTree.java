package Day155;

public class HeightOfBinaryTree {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+ Math.max(height(root.left), height(root.right));
    }
    static boolean isHeightBalanced(Node root){
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(root.left != null) lh++;
        if(root.right != null) rh++;
        int diff = lh-rh;
        if(diff <0) diff = -diff;
        if(diff >1) return false;
        return isHeightBalanced(root.left) && isHeightBalanced(root.right);
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
        System.out.println(height(root));
        System.out.println(isHeightBalanced(root));
    }
}
