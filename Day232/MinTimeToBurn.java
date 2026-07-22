package Day232;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToBurn {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void parentMap(Node root, HashMap<Node,Node> mp){
        if(root == null) return;
        if(root.left != null){
            mp.put(root.left, root);
        }
        if(root.right != null){
            mp.put(root.right, root);
        }
        parentMap(root.left, mp);
        parentMap(root.right, mp);
    }
    static int minTime(Node root,Node target){
        HashMap<Node,Node> parent = new HashMap<>();
        parentMap(root, parent);
        int time = 0;
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for(int i = 0;i<size;i++){
                Node top = q.poll();
                if(top.left != null && !visited.contains(top.left)){
                    visited.add(top.left);
                    q.add(top.left);
                    flag = true;
                }
                if(top.right != null && !visited.contains(top.right)){
                    visited.add(top.right);
                    q.add(top.right);
                    flag = true;
                }
                if(parent.containsKey(top) && !visited.contains(parent.get(top))){
                    visited.add(parent.get(top));
                    q.add(parent.get(top));
                    flag = true;
                }
            }
            if(flag){
                time++;
            }
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
        System.out.println(minTime(root, c));
    }
    
}
