package Day135;
import java.util.*;
import java.util.LinkedList;

public class BSTfromPreOrder {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
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
    static Node build(int[] arr,int bound,int[] i){
        if(i[0] == arr.length || arr[i[0]]>bound) return null;
        Node root =  new Node(arr[i[0]++]);
        root.left = build(arr, root.val, i);
        root.right = build(arr, bound, i);
        return root;
    }
    static Node buildTree(int[] arr){
        return build(arr, Integer.MAX_VALUE, new int[] {0});
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
        Node head = buildTree(new int[] {8,5,1,7,10,12});
        levelOrderq(head);
    }
    
}
