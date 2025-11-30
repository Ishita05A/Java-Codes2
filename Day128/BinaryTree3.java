package Day128;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree3 {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isMirrot(Node p ,Node q){
        if(p == null && q == null) return true;
        if(p == null || q==null) return false;
        return isMirrot(p.left, q.right) && isMirrot(p.right, q.left);
    }
    static Node invert_tree(Node root){
        if(root == null) return root;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invert_tree(root.left);
        root.right = invert_tree(root.right);
        return root;

    }
    
    static boolean isSame(Node p,Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    static boolean isSymmetric(Node root){
       if((root == null) ) return true;
        return isMirrot(root.left, root.right);
    }
    static void nthlevel(Node root,int n,ArrayList<Integer> ans){
        if(root == null) return;
        if(n == 1) {
            ans.add(root.val);
            return;
        }
        nthlevel1(root.left, n-1,ans);
        nthlevel1(root.right, n-1,ans);
    }
    static void nthlevel1(Node root,int n,ArrayList<Integer> ans){
        if(root == null) return;
        if(n == 1) {
            ans.add(root.val);
            return;
        }
         nthlevel1(root.right, n-1,ans);
        nthlevel1(root.left, n-1,ans);
    }
    static int levelHeight(Node root){
        if(root == null) return 0;
        return 1+Math.max(levelHeight(root.left), levelHeight(root.right));
    }
    static List<List<Integer>> zig_zag_traversal(Node root){
        int n = levelHeight(root);
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null
        ) return ans;
        for(int i = 1;i<=n;i++){
            ArrayList<Integer> a = new ArrayList<>();
            if(i%2 == 0)  nthlevel1(root, i,a);
            else nthlevel(root, i, a);
            ans.add(a);
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
        System.out.println(isSymmetric(root));
       List<List<Integer>> ans = zig_zag_traversal(root);   
       System.out.println(ans); 
    }
    
}
