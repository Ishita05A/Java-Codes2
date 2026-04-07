package Day210;

public class TopView_Recursion {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static int minHd = 0;
    static int maxHd = 0;
    static void findRange(Node root,int hd){
        if(root == null) return;
        minHd = Math.min(hd, minHd);
        maxHd = Math.max(hd, maxHd);
        findRange(root.left, hd-1);
        findRange(root.right, hd+1);
    }
    static void dfs(Node root,int hd,int level,int[] ans,int[] lvl){
        if(root == null) return;
        int idx = hd - minHd;

        if(lvl[idx] >level){
            lvl[idx] = level;
            ans[idx] = root.val;
        }
        dfs(root.left, hd-1, level+1, ans, lvl);
        dfs(root.right, hd+1, level+1, ans, lvl);
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
        findRange(root, 0);
        int range = maxHd-minHd+1;
        int[] lvl = new int[range];
        int[] ans = new int[range];
        for(int i = 0;i<range;i++){
            lvl[i] = Integer.MAX_VALUE;
        }
        dfs(root, 0, 0, ans, lvl);
        for(int i = 0;i<range;i++){
            System.out.print(ans[i]+" ");
        }


        
    }

}
