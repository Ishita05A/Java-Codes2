package Day104;

public class smallestAncestor {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static boolean isContain(Node root,Node p){
        if(root == null) return false;
        if(root == p) return true;
        return isContain(root.left, p) && isContain(root.right, p);
    }
    static Node smallest_ancestor(Node root,Node p,Node q){
        if(root == p && root == q) return root;
        if(p == q) return p;
        boolean l = isContain(root.left, p);
        boolean r = isContain(root.right, p);
        if((l && r) || (!l && !r)) return root;
        if(!l && r) return smallest_ancestor(root.right, p, q);
        if(l && r) return smallest_ancestor(root.left, p, q);
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
        System.out.println(smallest_ancestor(root, c, e).val);
    }
    
}
