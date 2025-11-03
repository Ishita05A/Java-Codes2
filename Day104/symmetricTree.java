package Day104;



public class symmetricTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    
    static Node invert_Tree(Node root){
        if(root == null) return root;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invert_Tree(root.left);
        root.right = invert_Tree(root.right);
        return root;
    }
    static boolean isBalanced(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isBalanced(root1.left, root2.left) && isBalanced(root1.right, root2.right);
        
    }
    static boolean isSymmetric(Node root){
        if(root == null) return true;
        if(root.left == null && root.right ==null) return true;
        root.left = invert_Tree(root.left);
        return isBalanced(root.left, root.right);
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
        System.out.println(isSymmetric(root));
    }
    
}
