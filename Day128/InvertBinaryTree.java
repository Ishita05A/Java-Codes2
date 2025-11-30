package Day128;

public class InvertBinaryTree {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void nthLevel(Node root,int n){
        if(root == null) return;
        if(n == 1) System.out.print(root.val+" ");
        nthLevel(root.left, n-1);
        nthLevel(root.right, n-1);
    }
    static void invert_tree(Node root){
        if(root == null) return;
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert_tree(root.left);
        invert_tree(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        for(int i = 1;i<=3;i++){
            nthLevel(root, i);
        }
        invert_tree(root);
        System.out.println();
        for(int i = 1;i<=3;i++){
            nthLevel(root, i);
        }
    }
    
}
