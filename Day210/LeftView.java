package Day210;

import java.util.Arrays;

public class LeftView {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static int lvl = 0;
    static void findLevel(Node root,int level){
        if(root == null) return;
        lvl = Math.max(level, lvl);
        findLevel(root.left, level+1);
        findLevel(root.right, level+1);
    }
    static void dfs(Node root,int level,int[] ans){
        if(root == null) return;
        if(ans[level] == -1){
            ans[level] = root.val;
        }
        dfs(root.left, level+1, ans);
        dfs(root.right, level+1, ans);
        
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
        findLevel(root, 0);
        int[] ans = new int[lvl+1];
        Arrays.fill(ans, -1);
        dfs(root, 0, ans);
        for(int i = 0;i<=lvl;i++){
            System.out.print(ans[i]+" ");
        }
    }
    
}
