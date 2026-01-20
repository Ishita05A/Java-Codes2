package Day159;
import java.util.*;
public class PathSumII {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void helper(Node root,int targetSum,List<Integer> arr,List<List<Integer>> ans){
        if(root == null)  return;
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
        } 
        arr.add(root.val);
        helper(root.left, targetSum-root.val, arr, ans);
        helper(root.right, targetSum-root.val, arr, ans);
        arr.remove(arr.size()-1);

    }
    static List<List<Integer>> pathSumII(Node root,int targetSum){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(root, targetSum, arr, ans);
        return ans;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);        
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(4);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(pathSumII(root,8));
    }
    
}
