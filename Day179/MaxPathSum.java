package Day179;

public class MaxPathSum {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void helper(Node root,int sum,int max){
        if(root == null) return;
        sum+=root.val;
        max = Math.max(max,sum);
        helper(root.left, sum,max);
        helper(root.right,sum,max);
        sum-=root.val;
    }
    static int maxPathSum(Node root){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        helper(root, sum, max);
        return max;
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(4);
        Node f = new Node(3);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(maxPathSum(root));
    }
    
}
