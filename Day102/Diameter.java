package Day102;

public class Diameter {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1 + height(root.left) + height(root.right);
    }

    static int diameter(Node root){
        if(root == null) return 0;
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int mid = height(root.left) + height(root.right);
        if(root.left != null) ld++;
        if(root.right != null) rd++;
        return Math.max(mid, Math.max(rd, ld));
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
        b.right = e;
        c.left = f;
        System.out.println(diameter(root));
    }
    
}
