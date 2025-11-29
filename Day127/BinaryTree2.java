package Day127;

import java.util.ArrayList;

public class BinaryTree2 {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isPresent(Node root,Node p){
        if(root == null) return false;
        if(root == p) return true;
        return isPresent(root.left, p) || isPresent(root.right, p);
    }
    static Node lowest_common_ancestor(Node root,Node p,Node q){
        if(root == null || root == p || root == q) return root;
       if(p==q) return p;
        boolean leftp = isPresent(root.left, p);
        boolean rightq = isPresent(root.right, q);
        if((leftp && rightq) || (!leftp && !rightq)) return root;
        if(leftp && !rightq) return lowest_common_ancestor(root.left, p, q);
        if(!leftp && rightq) return lowest_common_ancestor(root.right, p, q);
        return null;
    }
    static void helper(Node root,ArrayList<String >ans,String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            s+=root.val;
            ans.add(s);
            return;
        }
        helper(root.left, ans, s+root.val+" -> ");
        helper(root.right, ans,s+ root.val+" ->");
    }
    static ArrayList<String> pathOfTree(Node root){
       ArrayList<String> ans = new ArrayList<>();
       String a = "";
       helper(root, ans, a);
       return ans;
    }
    static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1+Math.max(height(root.right),height(root.left));
    }
    static boolean isSame(Node p,Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val ) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);

    }
    static boolean isBalanced(Node root){
        if(root == null) return true;
        int left_ans = height(root.left);
        if(root.left != null) left_ans++;
        int right_ans = height(root.left);
        if(root.right != null) right_ans++;
        int diff = left_ans - right_ans;
        if(diff<0) diff = -diff;
        if(diff>1) return false;
        return isBalanced(root.left) && isBalanced(root.right); 
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(4);
        Node e = new Node(4);
        Node f = new Node(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
         Node root1 = new Node(1);
        Node a1 = new Node(2);
        Node b1 = new Node(2);
        Node c1 = new Node(4);
        Node d1 = new Node(4);
        Node e1 = new Node(4);
        Node f1 = new Node(4);
        root1.left = a1;
        root1.right = b1;
        a1.left = c1;
        a1.right = d1;
        b1.left = e1;
        b1.right = f1;
        System.out.println(isBalanced(root));
        System.out.println(isSame(root,root1));
        pathOfTree(root);
        ArrayList<String> ans = pathOfTree(root);
        System.out.println(ans);
    }
    
}
