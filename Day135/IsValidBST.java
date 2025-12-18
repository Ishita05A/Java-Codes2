package Day135;

public class IsValidBST {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static boolean isValid(Node root,int minValue,int maxValue){
        if(root == null) return true;
        if(root.val < minValue || root.val > maxValue) return false;
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }
    static boolean isValidBST(Node root){
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        Node a = new Node(5);
        Node b = new Node(12);
        Node c = new Node(4);
        Node d = new Node(7);
        Node e = new Node(10);
        Node f = new Node(14);
        Node g = new Node(6);
        Node h = new Node(13);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        f.left = h;
        System.out.println(isValidBST(root));
    }
    
}
