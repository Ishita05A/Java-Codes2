package Day181;

public class MaxSumPath {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int max = Integer.MIN_VALUE;
    static int maxSum(Node root){
        if(root == null) return 0;
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        max = Math.max(max,  right + left + root.val);
        return Math.max(left, right) + root.val;
    }
    static int maxPathSum(Node root){
       max  = Integer.MIN_VALUE;
       maxSum(root);
       return max;
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
        System.out.println(maxPathSum(root));
    }
    
}
