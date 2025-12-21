package Day138;



public class isBalancedBinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static int heightOfTree(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1+Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
    static boolean isBalanced(Node root){
        if(root == null) return true;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        if(root.left != null) lh++;
        if(root.right != null) rh++;
        int diff = lh-rh;
        if(diff<0) diff = -diff;
        if(diff>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

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
        System.out.println(isBalanced(root));
    }
    
}
