package Day133;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static class Pair{
       
        Node node;
         int num;
        Pair(Node node,int num){
            this.node = node;
            this.num = num;
        }
    }
    static int maxWidth(Node root){
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int last = 0;
            int first = 0;
            int mmin = q.peek().num;
            for(int i  =0 ;i<size;i++){
                Pair top = q.poll();
                int curr_id = top.num-mmin;
                if(i == 0) first = curr_id;
                if(i == size-1) last = curr_id;
                if(top.node.left!= null) q.add(new Pair(top.node.left, 2*curr_id+1));
                if(top.node.right != null ) q.add(new Pair(top.node.right, 2*curr_id+2));
            }
            ans = Math.max(last-first+1, ans);
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = g;
        b.left = e;
        b.right = f;
        f.left = h;
        f.right = i;
        System.out.println(maxWidth(root));
    }
    
}
