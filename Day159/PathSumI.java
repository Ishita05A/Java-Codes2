package Day159;

public class PathSumI {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isPathSum(Node root ,int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == targetSum) return true;
        }
        return isPathSum(root.left, targetSum-root.val) || isPathSum(root.right, targetSum-root.val);

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
        System.out.println(isPathSum(root, 7));
    }
    
}
