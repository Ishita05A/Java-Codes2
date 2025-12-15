package Day132;



public class isSymmetric {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static Node invert(Node root){
        if(root == null) return root;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invert(root.left);
        root.right = invert(root.right);
        return root;
    }
    static boolean isIdentical(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    static boolean is_symmetric(Node root){
        if(root == null) return true;
        root.right =  invert(root.right);
        return isIdentical(root.left ,root.right);
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(10);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = g;
        b.left = e;
        b.right = f;
        f.left = h;
        f.right = i;
        System.out.println(is_symmetric(root));
    }
    
}
