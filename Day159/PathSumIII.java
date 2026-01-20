package Day159;

public class PathSumIII {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int helper(Node root, int targetSum){
        if(root == null) return 0;
        int count=0;
        if(root.val == targetSum){
            count++;
        }
        return count + helper(root.left, targetSum-root.val) + helper(root.right, targetSum-root.val);
    }
    static int path_sumIII(Node root,int targetSum){
        if(root == null) return 0;
        int count = helper(root, targetSum);
        return count + path_sumIII(root.left, targetSum) + path_sumIII(root.right, targetSum);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);        
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(4);
        Node f = new Node(7);
        Node g = new Node(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        f.left = g;
        System.out.println(path_sumIII(root,8 ));
    }
    
}
