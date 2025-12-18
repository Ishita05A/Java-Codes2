package Day135;

public class CeilInBinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static int ceil_in_binaryTree(Node root, int target) {
        Node node = root;
        while (root != null) {
            if (root.val < target)
                root = root.right;
            else {
                node = root;
                root = root.left;
            }
            
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
        System.out.println(ceil_in_binaryTree(root, 3));
    }

}
