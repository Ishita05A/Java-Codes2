package Day119;

public class DisplayBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int sumOfTreeNode(Node root){
        if(root == null) return 0;
        return root.val+sumOfTreeNode(root.right)+sumOfTreeNode(root.left);
    }
    static int sizeOfBT(Node root){
        if(root == null) return 0;
        return 1+sizeOfBT(root.left) + sizeOfBT(root.right);
    }
    static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+"->" );
        if(root.left != null) System.out.print(root.left.val+" "); else System.out.print("n ");
        if(root.right != null) System.out.print(root.right.val+" "); else System.out.print("n ");
        System.out.println();
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c= new Node(4);
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
        System.out.println(sizeOfBT(root));
        System.out.println(sumOfTreeNode(root));
    }
    
}
