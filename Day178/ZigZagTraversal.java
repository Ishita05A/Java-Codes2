package Day178;

import java.util.*;
public class ZigZagTraversal {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void leftTraversal(Node root,List<Integer> ans){
        if(root.left == null && root.right == null){
            return;
        }
        ans.add(root.val);
        if(root.left != null) leftTraversal(root.left, ans);
        else leftTraversal(root.right, ans);
    }
    static void leafNode(Node root,List<Integer> ans){
        if(root == null || (root.left == null && root.right == null)) {
            ans.add(root.val);
            return;
        }
        leafNode(root.left, ans);
        leafNode(root.right, ans);
    }
    static void rightTraversal(Node root,Stack<Integer> st){
        
        if(root == null || (root.left == null && root.right == null)) return;
        st.push(root.val);
        if(root.right != null) rightTraversal(root.right, st);
        else rightTraversal(root.left, st);
    }
    static List<Integer> boundary(Node root){
        List<Integer> ans = new ArrayList<>();
        leftTraversal(root, ans);
        leafNode(root, ans);
        Stack<Integer> st = new Stack<>();
        rightTraversal(root, st);
        while (st.size() != 1) {
            ans.add(st.pop());
        }
        return ans;
    }
    static int level(Node root){
        if(root == null ) return 0;
        return 1+Math.max(level(root.left), level(root.right));
    }
    static void addOdd(Node root,int level,List<Integer> a){
        if(root == null) return;
        if(level == 1 ){
            a.add(root.val);
        }
        addOdd(root.left, level-1, a);
        addOdd(root.right, level-1, a);
    }
     static void addEven(Node root,int level,List<Integer> a){
        if(root == null) return;
        if(level == 1 ){
            a.add(root.val);
        }
        addOdd(root.right, level-1, a);
        addOdd(root.left, level-1, a);
        
    }
    static void zigzag(Node root,int level,List<Integer> a){
        if(root == null) return;
        if(level%2 != 0){
            addOdd(root, level,a);
        }
        else{
            addEven(root, level, a);
        }
        
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
        int level = level(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<=level;i++){
            List<Integer> aa = new ArrayList<>();
            zigzag(root, i, aa);
            ans.add(aa);
        }
        System.out.println(ans);
        List<Integer> arr = boundary(root);
        System.out.println(arr);
        

        
        
    }
    
}
