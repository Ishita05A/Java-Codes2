package Day158;

public class PathSumIII {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int noOfPath(Node root,int targetSum){
        if(root == null) return 0;
        int count = 0;
        if(root.val == targetSum) count++;
        return count+ noOfPath(root.left, targetSum-root.val) + noOfPath(root.right, targetSum-root.val);

    }
    static int pathSum(Node root,int targetSum){
        if(root == null) return 0;
        int count = noOfPath(root, targetSum);
        return count+pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);        
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(4);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(pathSum(root, 8));
    }
    
}
