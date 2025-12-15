package Day132;
import java.util.*;
public class PrintBoundary {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isLeaf(Node root){
       
        if(root.left == null && root.right == null) return true;
        return false;
    }
    static void rightBoundary(Node root,Stack<Node> st){
        if(root == null) return;
        if(isLeaf(root)==false) st.push(root);
        if(root.right != null) rightBoundary(root.right, st);
        else rightBoundary(root.left, st);
    
    }
    static void addLeaf(Node root,List<Integer> ans){
        if(root == null ) return;
         if(root.left == null && root.right == null) ans.add(root.val);
         if(root.left != null) addLeaf(root.left, ans);
        if(root.right != null) addLeaf(root.right, ans);
    }
    static void leftBoundary(Node root,List<Integer> ans){
        if(root == null) return;
        if(isLeaf(root) == false) ans.add(root.val);
        if(root.left != null) leftBoundary(root.left, ans);
        else leftBoundary(root.right, ans);
    }
    static List<Integer> printBoundary(Node root){
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(isLeaf(root) == false) ans.add(root.val); 
        if(root.left!= null) leftBoundary(root.left, ans);
        addLeaf(root, ans);
        Stack<Node> st = new Stack<>();
        if(root.right != null)rightBoundary(root.right, st);
        while(!st.isEmpty()){
            ans.add(st.pop().val);
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
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(10);
        Node j = new Node(11);
        root.left = a;
        root.right = f;
        a.left = b;
        b.right = c;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        h.left = i;
        h.right = j;
        List<Integer> ans = printBoundary(root);
        System.out.println(ans);
    }
    
}
