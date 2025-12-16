package Day133;


public class CountNodesInCompleteBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int getLeftHeight(Node root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }
    static int getRightHeight(Node root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }
    static int countNodes(Node root){
        if(root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right) return ((1<<(left))-1);
        return countNodes(root.left)+countNodes(root.right)+1;
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
        c.left = h;
        c.right = i;
        System.out.println(countNodes(root));
    }
    
}
