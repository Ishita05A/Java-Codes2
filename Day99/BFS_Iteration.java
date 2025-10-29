package Day99;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Iteration {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(q.size()>0){
            if(q.peek().left != null) q.add(q.peek().left);
            if(q.peek().right != null) q.add(q.peek().right);
            System.out.print(q.peek().val+" ");
            q.remove();
        } 
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        c.left = f;
        bfs(root);
    }
    
}
