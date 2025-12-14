package Day131;

public class IdenticalTwin {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    
    static boolean isIdentical(Node root1,Node root2){
        if(root1 == null && root2 == null ) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
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

         Node root1 = new Node(1);
        Node a1 = new Node(2);
        Node b1 = new Node(3);
        Node c1 = new Node(4);
        Node d1 = new Node(5);
        Node e1 = new Node(6);
        Node f1 = new Node(7);
        Node g1 = new Node(8);
        Node h1 = new Node(9);
        Node i1 = new Node(10);
        root1.left = a1;
        root1.right = b1;
        a1.left = c1;
        a1.right = d1;
        d1.left = g1;
        b1.left = e1;
        b1.right = f1;
        f1.left = h1;
        f1.right = i1;
        System.out.println(isIdentical(root, root1));
    }
    
}
