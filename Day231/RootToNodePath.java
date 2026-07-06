package Day231;
import java.util.*;

import Day141.removeDuplicate;

public class RootToNodePath {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void helper(Node root, Node target, List<Integer> a,List<Integer> ans){
        if(root == null) return;
        if(root == target){
            a.add(root.val);
            ans.addAll(a);
        }
        a.add(root.val);
        helper(root.left, target, a, ans);
        helper(root.right, target, a, ans);
        a.remove(a.size()-1);
    }
    static List<Integer> printPath(Node root,Node target){
        List<Integer> a = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(root, target, a, ans);
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
        System.out.println(printPath(root, e));
    }
    
}
