package Day230;
import java.util.*;
public class TopView {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void helper(Node root, TreeMap<Integer,Integer> mp,int line){
        if(root == null) return;
        if(!mp.containsKey(line)){
            mp.put(line, root.val);
            if(root.left != null) helper(root.left, mp, line-1);
            if(root.right != null) helper(root.right, mp, line+1);
        }

    }
    static void helper_bottom(Node root,TreeMap<Integer,Integer> mp,int line){
        if(root == null) return;
        mp.put(line, root.val);
        if(root.left != null) helper_bottom(root.left, mp, line-1);
        if(root.right != null) helper_bottom(root.right, mp, line+1);
    }
    static List<Integer> bottomView(Node root){
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        helper_bottom(root, mp, 0);
        for(var e : mp.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
    static List<Integer> topView(Node root){
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        helper(root, mp, 0);
        for(var e : mp.entrySet()){
            ans.add(e.getValue());
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
        System.out.println(topView(root));
        System.out.println(bottomView(root));
    }
    
}
