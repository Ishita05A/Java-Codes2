package Day156;

public class IsSymetric {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void reverse(Node root){
        if(root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }
    static boolean is_identical(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return is_identical(root1.left, root2.left) && is_identical(root1.right, root2.right);
    }
    static boolean is_symmetric(Node root){
        reverse(root.right);
        return is_identical(root.left, root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);        
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(5);
        Node f = new Node(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(is_symmetric(root));
    }
    
}
