package Day100;

import java.util.ArrayList;
public class InorderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }

    static ArrayList<Integer> inorder(Node root){
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> ansl = inorder(root.left);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(ansl);
        ans.add(root.val);
        ArrayList<Integer> ansr =inorder(root.right);
        ans.addAll(ansr);
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
        ArrayList<Integer> ans =inorder(root);
        System.out.println(ans);
    }
    
}
