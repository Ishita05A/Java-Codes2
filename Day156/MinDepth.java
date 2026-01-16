package Day156;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    static int findMinDepth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        int depth = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (!q.isEmpty() && size > 0) {
                Node top = q.poll();
                if (top.left == null && top.right == null)
                    return depth;
                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);

                size--;
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(5);
        Node f = new Node(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(findMinDepth(root));
    }

}
