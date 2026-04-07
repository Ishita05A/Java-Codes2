package Day208;

public class BoundaryTraversal {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static void leftTraversal(Node root){
        if((root == null) || (root.left == null && root.right == null)) return;
        System.out.print(root.val+" ");
        if(root.left != null) leftTraversal(root.left);
        else leftTraversal(root.right);
    }
    static void leafNode(Node root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            System.out.print(root.val+" ");
        }
        leafNode(root.left);
        leafNode(root.right);
    }
    static void rightTraversal(Node root){
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.right != null) rightTraversal(root.right);
        else{
            rightTraversal(root.left);
        }
        System.out.print(root.val+" ");
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
        System.out.print(root.val+" ");
        leftTraversal(root.left);
        leafNode(root);
        rightTraversal(root.right);
        
    }
    
}
