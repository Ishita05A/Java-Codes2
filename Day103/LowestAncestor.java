package Day103;

public class LowestAncestor {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }

    static boolean contains(Node root,Node p){
        if(root == p) return true;
        if(root == null) return false;
        return contains(root.left, p) || contains(root.right, p);
    }

    static Node lowest_ancestor(Node root,Node p,Node q){
        if(root == p || root == q) return root;
        if(p == q) return p;
        boolean l = contains(root.left, p);
        boolean r = contains(root.right, q);
        if((l && r) || (!l && !r)) return root;
        if(!l && r) return lowest_ancestor(root.right, p, q);
        if(l && !r) return lowest_ancestor(root.left, p, q);
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
        b.right = e;
        c.left = f;
        Node ans = lowest_ancestor(root, b, e);
        System.out.println(ans.val);
    }
    
}
