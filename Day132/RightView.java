package Day132;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class RightView {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static void getrightView(Node root,int level,Queue<Node> q){
        if(root == null) return;
        if(q.size() == level) q.add(root);
        if(root.right != null) getrightView(root.right, level+1, q);
        if(root.left != null) getrightView(root.left   , level+1, q);

    }
    static List<Integer> rightView(Node root){
        Queue<Node> q = new LinkedList<>();

        List<Integer> ans = new ArrayList<>();
        getrightView(root, 0, q);
        while (!q.isEmpty()) {
            ans.add(q.remove().val);
        }
        return ans;
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
        Node j = new Node(11);
        root.left = a;
        root.right = f;
        a.left = b;
        b.right = c;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        h.left = i;
        h.right = j;
        System.out.println(rightView(root));
    }
    
}
