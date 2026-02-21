package Day183;
import java.util.*;
public class AllNodeAtDistK {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static List<Integer> nodesAtDistK(Node root,Node target,int k){
        Queue<Node> q = new LinkedList<>();
        
        HashMap<Node,Node> mp = new HashMap<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.poll();
            if(top.left != null) {
                if(!mp.containsKey(top.left)) q.add(top.left);
                if(!mp.containsKey(top.left)) mp.put(top.left, top); 
            }
            if(top.right != null){
                if(!mp.containsKey(top.right)) q.add(top.right);
                if(!mp.containsKey(top.right)) mp.put(top.right, top);
            }
        }
        q.add(target);
        int dist = 0;
        HashSet<Node> vis = new HashSet<>();
        vis.add(target);
        while(dist != k){
            int size = q.size();
            for(int i = 1;i<=size;i++){
                Node top = q.poll();
                if(top.left != null && !vis.contains(top.left)){
                    q.add(top.left);
                    vis.add(top.left);
                }
                if(top.right != null && !vis.contains(top.right)){
                    q.add(top.right);
                    vis.add(top.right);
                }
                if(mp.containsKey(top) && !vis.contains(mp.get(top))){
                    q.add(mp.get(top));
                    vis.add(mp.get(top));
                }
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>(); 
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(nodesAtDistK(root, a, 1));
    }
    
}
