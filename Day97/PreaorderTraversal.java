package Day97;

public class PreaorderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static void preOrder_Traversal(Node root){
        if(root == null) return;
        System.out.println(root.val);
        preOrder_Traversal(root.left);
        preOrder_Traversal(root.right);

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
        preOrder_Traversal(root);

        

    }
    
}
