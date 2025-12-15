package Day132;

public class LowestCommonAncestor {
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
        return isContain(root.left,p) || isContain(root.right, p);
    }

    static Node lca1(Node root,Node p,Node q){
        if(root == null || root == p || root == q) return root;
        Node left = lca1(root.left, p, q);
        Node right = lca1(root.right, p, q);
        if(left == null) return right;
        if(right == null ) return left;
        else return root;
    }
    static Node lca(Node root,Node p,Node q){
        if(root == p || root == q) return root;
        if(p == q) return p;
        boolean l = isContain(root.left, p);
        boolean r = isContain(root.right, q);
        if((l && r) || (!l && !r)) return root;
        if(!l && r) return lca(root.right, p, q);
        if(l && !r) return lca(root.left, p, q);
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
        System.out.println(lca1(root, h, i).val);
    }
    
}
