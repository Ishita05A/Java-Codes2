package Day135;

import java.util.LinkedList;
import java.util.*;
public class DeleteInBST {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static Node last_right(Node root){
        while(root.right != null) root = root.right;
        return root;
    }
    static Node helper(Node root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        Node right = root.right;
        Node lastRight = last_right(root.left);
        lastRight.right = right;
        return root.left;
    }
    static Node delete(Node root,int key){
        Node dummy = root;
        while(root != null){
            if(root.val == key) return helper(root);
        if(root.val>key){
            if(root.left != null && root.left.val == key){
                root.left = helper(root.left);
            }
            else root = root.left;
        }
        else{
            if(root.right != null && root.right.val == key){
                root.right = helper(root.right);
            }
            else root = root.right;
        }
        }
        return dummy;
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
        Node head = delete(root, 8);
        levelOrderq(head);


    }
    
}
