package Day132;
import java.util.*;
public class BottomView {
    static class Pair{
        int x;
        Node node;
        Pair(int x,Node node){
            this.x = x;
            this.node = node;
        }
    }
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static List<Integer> bottomView(Node root){
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>(); 
        TreeMap<Integer,Node> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair top = q.poll();
            if(top.node.left != null) q.add(new Pair(top.x-1,top.node.left));
            if(top.node.right != null) q.add(new Pair(top.x+1,top.node.right));
            if(!map.containsKey(top.x)) map.put(top.x, top.node);
            else map.put(top.x, top.node);
        }
        for(Node temp : map.values()){
            ans.add(temp.val);
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
        Node j = new Node(11);
        root.left = a;
        root.right = f;
        a.left = b;
        b.right = c;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        h.left = i;
        h.right = j;
        System.out.println(bottomView(root));

    }
    
}
