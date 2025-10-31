package Day101;

public class LevelOrderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }

    static int height(Node root){
        if(root == null ) return 0;
        return 1+ Math.max(height(root.left), height(root.right));

    }
    static void level_traverse(Node root,int n){
        if(root == null) return;
        if(n == 1) System.out.print(root.val+" ");
        
        level_traverse(root.left, n-1);
        level_traverse(root.right, n-1);

        
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
        int n = height(root);
        for(int i = 1;i<=n;i++){
            level_traverse(root, i);
            System.out.println();
        }
    }
    
}
