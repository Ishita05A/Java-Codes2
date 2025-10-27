package Day97;

public class Height_of_Tree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static int edge_height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(edge_height(root.left), edge_height(root.right));
    }

    static int level_height(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(level_height(root.left), level_height(root.right));
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
        System.out.println(edge_height(root));
        System.out.println(level_height(root));
    }
    
}
