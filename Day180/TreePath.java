package Day180;

import java.util.*;
public class TreePath {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int max = Integer.MIN_VALUE;
    static int maxSum(Node root){
        if(root == null) return 0;
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        max = Math.max(max, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
    static int maxPathSum(Node root){
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }
    static int noOfPath(Node root,int targetSum){
        if(root == null) return 0;
        int count = 0;
        if(targetSum == root.val) count++;
        return count + noOfPath(root.left, targetSum-root.val) + noOfPath(root.right, targetSum-root.val);
    }
    static int pathSum3(Node root,int target){
        if(root == null) return 0;
        int count = noOfPath(root, target);
        count+=pathSum3(root.left, target);
        count += pathSum3(root.right, target);
        return count;
    }
    static void helper2(Node root,int targetSum,List<List<Integer>> ans,List<Integer> a){
        if(root == null) return;
        if( root.left == null && root.right == null){
            if(targetSum == root.val){
                List<Integer> arr = new ArrayList<>();
                a.add(root.val);
                for(int i = 0;i<a.size();i++){
                    arr.add(a.get(i));
                }
                ans.add(arr);
                a.remove(a.size()-1);
                return;
            }
            a.add(root.val);
            helper2(root.left, targetSum-root.val, ans, a);
            helper2(root.right, targetSum-root.val, ans, a);
            a.remove(a.size()-1);
        }
        a.add(root.val);
        helper2(root.left,targetSum-root.val,ans,a);
        helper2(root.right,targetSum-root.val,ans,a);
        a.remove(a.size()-1);
    }
    static List<List<Integer>> pathSum2(Node root,int targetSum){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> a  = new ArrayList<>();
            helper2(root, targetSum, ans, a);
            return ans;
        }
    static boolean pathSum1(Node root,int targetSum){
        if(root == null) return false;
        if(root != null && ( root.left == null && root.right == null)){
            if(targetSum == root.val) return true;
        }
        return pathSum1(root.left, targetSum-root.val) || pathSum1(root.right, targetSum-root.val);

    }
    static void helper(Node root,List<String> str,String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            s+=root.val;
            str.add(s);
            return;
        }
        helper(root.left, str, s+root.val+"->");
        helper(root.right, str, s+root.val+"->");
    }

    static List<String> path(Node root){
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(4);
        Node e = new Node(6);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(path(root));
        System.out.println(pathSum1(root, 33));
        System.out.println(pathSum2(root,7 ));
        System.out.println(pathSum3(root, 7));
        System.out.println(maxPathSum(root));
    }
}
