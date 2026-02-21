package Day183;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurnTheTree {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int timeToBurn(Node root,Node target){
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> mp = new HashMap<>();
        q.add(root);
        while (!q.isEmpty()){
            Node top = q.poll();
            if(top.left != null){
                q.add(top.left);
                mp.put(top.left, top);
            }
            if(top.right != null){
                q.add(top.right);
                mp.put(top.right, top);
            }
        }
        q.add(target);
        HashSet<Node> vis = new HashSet<>();
        int time = 0;
        vis.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            int count = 0;
            for(int i = 1;i<=size;i++){
                Node top = q.poll();
                if(top.left != null && !vis.contains(top.left)){
                    q.add(top.left);
                    vis.add(top.left);
                    count++;
                }
                if(top.right != null && !vis.contains(top.right)){
                    q.add(top.right);
                    vis.add(top.right);
                    count++;
                }
                if(mp.containsKey(top) && !vis.contains(mp.get(top))){
                    q.add(mp.get(top));
                    vis.add(mp.get(top));
                    count++;
                }
            }
            if(count>0) time++;
        }
        return time;

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
        System.out.println(timeToBurn(root, a));
    }        
    
}
