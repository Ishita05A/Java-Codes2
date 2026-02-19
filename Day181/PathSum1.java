package Day181;

import java.util.*;

public class PathSum1 {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean pathSum1(Node root,int target){
        if(root == null) return false;
        if(root.val == target) return true;
        return pathSum1(root.left, target-root.val) || pathSum1(root.right, target-root.val);
    }
    static void helper(Node root, List<Integer> a, List<List<Integer>> ans,int target){
        if(root == null) return;
        if(root != null && (root.left == null && root.right == null)){
            if(root.val == target){
                List<Integer> arr = new ArrayList<>();
                a.add(root.val);
                for(int i = 0;i<a.size();i++){
                    arr.add(a.get(i));
                }
                ans.add(arr);
                a.remove(a.size()-1);
                
            }
            return;
        }
        a.add(root.val);
        helper(root.left, a, ans, target-root.val);
        helper(root.right, a, ans, target-root.val);
        a.remove(a.size()-1);
    }
    static List<List<Integer>> pathSum2(Node root,int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        helper(root, a, ans, target);
        return ans;
    }
    static int helper2(Node root,int target){
        if(root == null) return 0;
        int count = 0;
        if(root.val == target) count++;
        return count+helper2(root.left, target-root.val) +helper2(root.right, target-root.val);
    }
    static int pathSum3(Node root,int target){
        if(root == null) return 0;
        int count = helper2(root, target);
        return count + pathSum3(root.left, target) + pathSum3(root.right, target);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(3);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(pathSum1(root, 10));
        System.out.println(pathSum2(root, 7));
        System.out.println(pathSum3(root, 7));
    }
    
}
