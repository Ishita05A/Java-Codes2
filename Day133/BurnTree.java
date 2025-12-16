package Day133;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;

public class BurnTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int time_to_burn_tree(Node root,Node target){
        HashMap<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int time = 0;
        while(!q.isEmpty()){
            Node top = q.remove();
            if(top.left != null){
                q.add(top.left);
                mp.put(top.left, top);
            }
            if(top.right != null){
                q.add(top.right);
                mp.put(top.right, top);
            }
        }
        HashSet<Node> visited = new HashSet<>();
        q.add(target);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count = 0;
            while(size>0){
                Node top = q.poll();
                visited.add(top);
                if(top.left != null && !visited.contains(top.left)){
                    visited.add(top.left);
                    q.add(top.left);
                    count++;
                }
                if(top.right != null && !visited.contains(top.right)){
                    visited.add(top.right);
                    q.add(top.right);
                    count++;
                }
                if(mp.containsKey(top) && !visited.contains(mp.get(top))){
                    visited.add(mp.get(top));
                    q.add(mp.get(top));
                    count++;
                }
                size--;
                
            }
            if(count>0) time+=1;
            

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
        System.out.println(time_to_burn_tree(root, g));
    }
    
}
