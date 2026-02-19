package Day181;
import java.util.*;
public class VerticalOrder {
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
        int line;
        int level;
        Pair(Node node,int line,int level){
            this.node = node;
            this.line = line;
            this.level = level;
        }
    }
    static List<List<Integer>> vertical_order(Node root){
        if (root == null) return new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            Pair top = q.poll();
            Node node = top.node;
            int x = top.line;
            int y = top.level;
            mp.putIfAbsent(x, new TreeMap<>());
            mp.get(x).putIfAbsent(y, new PriorityQueue<>());
            mp.get(x).get(y).offer(node.val);
            if(node.left != null) q.offer(new Pair(node.left, x-1, y+1));
            if(node.right != null) q.offer(new Pair(node.right, x+1, y+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys : mp.values()){
            List<Integer> a = new ArrayList<>();
            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty()){
                    a.add(pq.poll());
                }
            }
            ans.add(a);
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(vertical_order(root));
    }
    
}
