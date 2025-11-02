package Day103;

public class ZigZagTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }    
    static void zig_zag(Node root,int n){
        if(root == null) return;
        if(n == 1) System.out.print(root.val+" ");
        zig_zag(root.right, n-1);
        zig_zag(root.left, n-1);
        
    }
    static void zig_zag1(Node root,int n){
        if(root == null) return;
        if(n==1) System.out.print(root.val+" ");
        zig_zag1(root.left, n-1);
        zig_zag1(root.right, n-1);
        
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
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
        for(int i =1;i<=n;i++){
            if(i%2 !=0) zig_zag1(root, i);
            else zig_zag(root, i);
            System.out.println();
        }
        
    }
    
}
