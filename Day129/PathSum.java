package Day129;
import java.util.*;
public class PathSum {
    
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    static void helper(Node root,int targetSum,List<List<Integer>> ans ,List<Integer> arr){
        if(root == null) return;
        if(root.left == null && root.right == null){
            arr.add(root.val);
            if(root.val == targetSum){
                List<Integer> a = new ArrayList<>();
                for(int i = 0;i<arr.size();i++){
                    a.add(arr.get(i));
                }
                ans.add(a);
            }
            arr.remove(arr.size()-1);
            return;
        }
        arr.add(root.val);
        helper(root.left, targetSum-root.val, ans, arr);
        helper(root.right, targetSum-root.val, ans, arr);

    
    }
   
    static boolean findPath_with_target_sum(Node root,int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == targetSum) return true;
        }
        return findPath_with_target_sum(root.left, targetSum-root.val) || findPath_with_target_sum(root.right, targetSum-root.val);
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
        System.out.println(findPath_with_target_sum(root, 13));
    }
    
}
