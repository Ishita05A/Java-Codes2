package Day207;

public class MediumProblems {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isIdentical(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isIdentical(root1.left,root2.left) && isIdentical(root1.right, root2.right);
        
    }
    static boolean isBalanced(Node root){
        if(root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int diff =left-right;
        if(diff<0) diff = -diff;
        if(diff > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    static int maxDepth(Node root){
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    static int diameter(Node root){
        if(root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        int mid = maxDepth(root.left)+maxDepth(root.right);
        if(root.left != null) mid++;
        if(root.right != null) mid++;
        return Math.max(Math.max(right, left), mid);
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
        System.out.println(maxDepth(root));
        System.out.println(isBalanced(root));
        System.out.println(diameter(root2));
        System.out.println(isIdentical(root, root2));
    }
    
}
