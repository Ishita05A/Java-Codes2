package Day159;

public class LowestCommonAncestor {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isPresent(Node root,Node target){
        if(root == null) return false;
        if(root == target) return true;
        return isPresent(root.left, target) || isPresent(root.right, target); 
    }
    static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        if(p == q) return p;
        boolean left = isPresent(root.left, p);
        boolean right = isPresent(root.right, q);
        if((!left && !right) ||  (left && right)) return root;
        if(!left && right) return lowestCommonAncestor(root.right, p, q);
        if(left && !right) return lowestCommonAncestor(root.left, p, q);
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
        System.out.println(lowestCommonAncestor(root, e, f).val);
    }
    
}
