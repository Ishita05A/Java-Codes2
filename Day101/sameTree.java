package Day101;

public class sameTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }

    static boolean is_same(Node root,Node root1){
        if(root == null && root1 == null) return true;
        if(root == null || root1 == null) return false;
        if(root1.val != root.val) return false;
        return is_same(root.left, root1.left) && is_same(root.right, root1.right); 
    }
    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
       
        root1.left = a;
        root1.right = b;
        a.left = c;
        a.right = d;

        Node root2 = new Node(1);
        Node w = new Node(2);
        Node x = new Node(3);
        Node y = new Node(4);
        Node z = new Node(5);
       
        root2.left = w;
        root2.right = x;
        w.left = y;
        w.right = z;
        System.out.println(is_same(root1, root2));
    }
    
}
