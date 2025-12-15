package Day132;
import java.util.*;
import java.util.LinkedList;

public class ChildrenSumProperty {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
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
    static void childrenSum(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left != null) child+=root.left.val;
        if(root.right != null) child+=root.right.val;
        if(child>=root.val) root.val = child;
        childrenSum(root.left);
        childrenSum(root.right);
        int tot = 0;
        if(root.left != null) tot+=root.left.val;
        if(root.right != null) tot+=root.right.val;
        if(root.left != null || root.right != null) root.val = tot;
        
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
        childrenSum(root);
        levelOrderq(root);
    }
    
}
