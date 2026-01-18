package Day157;

public class Diameter {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1+ Math.max(height(root.left), height(root.right));
    }
    static int diameter_ofBT(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        int lh = diameter_ofBT(root.left);
        int rh = diameter_ofBT(root.right);
        int mid = height(root.left)+height(root.right);
        if(root.left != null) mid++;
        if(root.right != null) mid++;
        return Math.max(Math.max(rh, lh), mid);
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
        System.out.println(diameter_ofBT(root));
    }
    
}
