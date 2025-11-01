package Day102;


import java.util.ArrayList;

public class BinaryTreePath {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static void helper(Node root,ArrayList<String> ans,String s){
        if(root == null) return;
         if(root.left == null && root.right == null){
            s += root.val;
            ans.add(s);
            return;
         }
         helper(root.left, ans, s+root.val+"->");
         helper(root.right, ans, s+root.val+"->");
    }
    static ArrayList<String> tree_Path(Node root){
       ArrayList<String> ans = new ArrayList<>();
       helper(root, ans, "");
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
        b.right = e;
        c.left = f;
        ArrayList<String> ans= tree_Path(root);
        System.out.println(ans);
    }
    
}
