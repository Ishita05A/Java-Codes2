package Day100;


import java.util.ArrayList;

public class PreOrderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }

    static ArrayList<Integer> preorder(Node root){
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> ansl = preorder(root.left);
        ArrayList<Integer> ansr = preorder(root.right);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(ansl);
        ans.addAll(ansr);
        ans.add(0,root.val);
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
        ArrayList<Integer> ans = preorder(root);
        System.out.println(ans);
    }
    
}
