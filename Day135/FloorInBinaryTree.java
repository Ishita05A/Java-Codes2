package Day135;

public class FloorInBinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static int floorInBinaryTree(Node root,int target){
        Node node = new Node(-1);
        while(root != null){
            if(root. val == target){
                return root.val;
            }
            else if(root.val < target){
                node = root;
                root = root.right;
            }
            else root = root.left;
        }
        return node.val;
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
        System.out.println(floorInBinaryTree(root, 3));
    }
    
}
