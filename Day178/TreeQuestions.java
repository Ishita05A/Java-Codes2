package Day178;

public class TreeQuestions {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int height(Node root){
        if((root == null) || (root.left == null && root.right == null)) return 0;
        return 1+ Math.max(height(root.left), height(root.right));
    }
    static boolean identical(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return identical(root1.left, root2.left) && identical(root1.right, root2.right);
    }
    static int diameter(Node root){
        if(root == null) return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        int mid = height(root.right) + height(root.left);
        if(root.right != null) mid++;
        if(root.left != null) mid++;
        return Math.max(mid,Math.max(rh, lh));        
    }

    static boolean isBalanced(Node root){
        if(root == null) return true;
        int lh = height(root.left);
        if(root.left != null) lh++;
        int rh = height(root.right);
        if(root.right != null) rh++;
        int diff = lh-rh;
        if(diff < 0) diff = -diff;
        if(diff> 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);  

    }
    static int maxDepth(Node root){
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
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
        System.out.println(diameter(root));
        System.out.println(identical(root, root2));
    }
    
}
