package Day131;

public class HeightOfTree {
     public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    
    static int edgeheight(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1+Math.max(edgeheight(root.left), edgeheight(root.right));
    }
    static boolean isBalalanced(Node root){
        if(root == null) return true;
        int lh = height(root.left);
        if(root.left != null) lh+=1;
        int rh = height(root.right);
        if(root.right != null) rh+=1;
        int diff = lh-rh;
        if(diff<0) diff=-diff;
        if(diff >1) return false;
        return isBalalanced(root.left) && isBalalanced(root.right);
        
    }
    static int findSum(Node root){
        if(root == null) return 0;
        return root.val + Math.max(findSum(root.left), findSum(root.right));
    }
    static int diameter(Node root){
        if(root == null ||(root.left == null && root.right == null)) return 0;
        int leftAns = diameter(root.left);
        int rightAns = diameter(root.right);
        int mid = edgeheight(root.left) + edgeheight(root.right);
        if(root.left != null) mid++;
        if(root.right != null) mid++;
        return Math.max(Math.max(rightAns, leftAns), mid);
        
    }
    static int findMaxSum(Node root, int max[]){
        if(root == null) return 0;
        int left = Math.max(0,findMaxSum(root.left, max));
        int right = Math.max(0, findMaxSum(root.right, max));
        max[0] = Math.max(left+right+root.val , max[0]);
        return Math.max(left,right)+root.val;
    } 
    static int maxPathSum(Node root){
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMaxSum(root, max);
        return max[0];

    }
    public static void main(String[] args) {
         Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(10);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = g;
        b.left = e;
        b.right = f;
        f.left = h;
        f.right = i;
        System.out.println(height(root));
        System.out.println(isBalalanced(root));
        System.out.println(diameter(root));
        System.out.println(maxPathSum(root));
    }
    
}
