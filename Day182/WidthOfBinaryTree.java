package Day182;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static class Pair{
        Node node;
        int level;
        Pair(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }
    static int maxWidth(Node root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        int first = 0;
        int last = 0;
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 1;i<=size;i++){
                Pair top = q.poll();
                int level = top.level;
                Node node = top.node;
                if(i == 1) first = level;
                if(i == size) last = level;
                if(node.left != null) q.add(new Pair(node.left, 2*(level-1)+1));
                if(node.right != null) q.add(new Pair(node.right, 2*(level-1)+2));
                max = Math.max(max, last-first+1);
            }
        }
        return max;
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
        b.left = e;
        b.right = f;
        System.out.println(maxWidth(root));
    }
    
}
