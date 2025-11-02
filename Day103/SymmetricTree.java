package Day103;

public class SymmetricTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static boolean sameTree(Node p,Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val ) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    static Node InvertTree(Node q){
        if(q==null) return null;
        Node temp = q.right;
        q.right = q.left;
        q.left = temp;
        q.left = InvertTree(q.left);
        q.right = InvertTree(q.right);
        return q;
    }
    static boolean symmetric_Tree(Node root){
        if(root == null) return true;
        
        root.left = InvertTree(root.left);
        return sameTree(root.left, root.right);
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
        System.out.println(symmetric_Tree(root));
    }
    
}
