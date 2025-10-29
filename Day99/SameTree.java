package Day99;

public class SameTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }

    static boolean isBalanced(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1== null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isBalanced(root1.left, root2.left) && isBalanced(root1.right, root2.right);
    }
    public static void main(String[] args) {
         Node root1 = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
       
        root1.left = a;
        root1.right = b;
        a.left = c;
        a.right = d;

        Node root2 = new Node(1);
        Node w = new Node(2);
        Node x = new Node(3);
        Node y = new Node(4);
        Node z = new Node(5);
       
        root2.left = w;
        root2.right = x;
        w.left = y;
        w.right = z;

        System.out.println(isBalanced(root1, root2));
       
    }
    
}
