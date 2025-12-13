package Day130;

public class BinaryTree {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int findmax(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(findmax(root.left), findmax(root.right)));
    }
    static void  display(Node root){
        if(root == null) 
            return;
        
        System.out.print(root.val+" -> ");
        if(root.left != null) System.out.print(root.left.val+" "); else System.out.print("n ");
        if(root.right != null) System.out.print(root.right.val+ " "); else System.out.print("n ");
        System.out.println();
        display(root.left);
        display(root.right);
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
        display(root);
        System.out.println(findmax(root));
    }
    
}
