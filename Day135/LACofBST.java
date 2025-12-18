package Day135;

public class LACofBST {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static Node lca_bst(Node root,Node p,Node q){
        if(root == p || root == q) return root;
        if(p == q) return p;
        if(root.val > p.val && root.val > q.val) return lca_bst(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return lca_bst(root.right, p, q);
        return root;
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
        System.out.println(lca_bst(root, c, d).val);
    }
    
}
