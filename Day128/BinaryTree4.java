package Day128;

public class BinaryTree4 {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean pathSum(Node root,int targetSum){
        if(root == null) return false;
        if((root != null) && (root.left == null && root.right == null)) {
            if(root.val == targetSum) return true;
        }
        return pathSum(root.left, targetSum-root.val) || pathSum(root.right, targetSum -root.val);
    }
    static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }
    static Node helper(int[] preOrder,int plow,int phigh,int[] inOrder,int inLow, int inHigh){
        if(plow>phigh) return null;
        Node root = new Node(preOrder[plow]);
        int i = inLow;
        while(inOrder[i] != preOrder[plow]) i++;
        int left_size = i-inLow;
        root.left = helper(preOrder, plow +1, left_size+plow, inOrder, inLow, i-1);
        root.right = helper(preOrder, plow+left_size+1, phigh, inOrder, i+1, inHigh);
        return root;
    }
    static Node buildTree(int[] preOrder,int[] inorder){
        int n = preOrder.length;
        return helper(preOrder, 0, n-1, inorder, 0, n-1);
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
        // int[] preOrder = {1,2,4,5,3,6};
        // int[] inorder = {4 ,2, 5, 1, 3, 6};
        // Node ans = buildTree(preOrder , inorder);
        // display(ans);
        System.out.println(pathSum(root, 7));
    }
    
}
