package Day182;

public class LCA {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean contains(Node root,Node p){
        if(root == null) return false;
        if(root == p) return true;
        return contains(root.left, p) || contains(root.right, p);        
    }
    static Node lowestCommonAncestor(Node root, Node p,Node q){
        if(root == p || root == q) return root;
        if(p == q) return p;
        boolean left = contains(root.left, p);
        boolean right = contains(root.right, q);
        if(left == true && right == true) return root;
        if(left == true && right == false) return lowestCommonAncestor(root.left, p, q);
        if(left == false && right == true) return lowestCommonAncestor(root.right, p, q);
        return root;
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
        System.out.println(lowestCommonAncestor(root, b, f).val);
    }
    
}
