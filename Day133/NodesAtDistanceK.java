package Day133;
import java.util.*;
public class NodesAtDistanceK {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static List<Integer> nodeAtDistK(Node root,Node target, int k){
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int dist = 0;
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.remove();
            if(top.left != null) {
                q.add(top.left);
                mp.put(top.left, top);
            }
            if(top.right != null){
                if(!mp.containsKey(top.right)) q.add(top.right);
                if(!mp.containsKey(top.right)) mp.put(top.right, top);
            } 
        }
        q.add(target);
        HashSet<Node> visited = new HashSet<>();
        while(dist != k){
            int size = q.size();
            while(size>0){
                Node top = q.poll();
                visited.add(top);
                if(top.left != null && !visited.contains(top.left) ) {
                    q.add(top.left);
                    visited.add(top.left);
                }
                if(top.right != null && !visited.contains(top.right) ) {
                    q.add(top.right);
                    visited.add(top.right);
                }
                if(mp.containsKey(top) && !visited.contains(mp.get(top))){
                    q.add(mp.get(top));
                    visited.add(mp.get(top));
                }
                size--;
            }
            dist++;
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
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
        System.out.println(nodeAtDistK(root, d, 2));
    }
    
}
