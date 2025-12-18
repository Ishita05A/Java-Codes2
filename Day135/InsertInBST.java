package Day135;
import java.util.*;
import java.util.LinkedList;

public class InsertInBST {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static Node insert(Node root,int val){
        Node head = root;
        Node node = new Node(val);
        while(root != null){
            if(node.val < root.val){
                if(root.left == null){ 
                    root.left = node;
                    return head;
                }
                 else root = root.left;
            }
            else{
                if(root.right == null){
                     root.right = node;
                    return head;
                }
                else root = root.right;
            }
        }
        return head;
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
        Node head = insert(root, 3);
        levelOrderq(head);
        

    }
    
}
