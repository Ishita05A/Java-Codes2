package Day138;
import java.util.*;
import java.util.LinkedList;

public class FlattenBTtoLL {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    private static  Node prev = null;
    static void flattenBinarytree(Node root){
        if(root == null) return;
        flattenBinarytree(root.right);
        flattenBinarytree(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

    }
     static void levelOrderq(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.element();
            System.out.print(top.val+" ");
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
            q.remove();
        }
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
        flattenBinarytree(root);
        levelOrderq(root);
        
    }
    
}
