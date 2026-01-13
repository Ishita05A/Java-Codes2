package Day155;

public class isIdentical {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean is_Identical(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1.val != root2.val) return false;
        return is_Identical(root1.left, root2.left) && is_Identical(root1.right, root2.right);
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

        Node root2 = new Node(1);
        Node u = new Node(2);
        Node v = new Node(3);
        Node w = new Node(4);
        Node x = new Node(5);
        Node y = new Node(6);
        Node z = new Node(7);
        root2.left = u;
        root2.right = v;
        u.left = w;
        u.right = x;
        v.left = y;
        v.right = z;
        System.out.println(is_Identical(root, root2));
    }
    
}
