package Day155;
import java.util.*;
public class BoundaryTraversalOfBinaryTree {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void leftBoundary(Node root,List<Integer> ans){
        if(root == null || root.left== null) return;
        ans.add(root.val);
        leftBoundary(root.left, ans);
    }
    static void rightBoundary(Node root,Stack<Integer> st){
        if(root == null || root.right == null) return;
        st.push(root.val);
        rightBoundary(root.right, st);
    }
    static void leafNodes(Node root,List<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.val);
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    static List<Integer> boundaryTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        leftBoundary(root, ans);
        leafNodes(root, ans);
        Stack<Integer> st = new Stack<>();
        rightBoundary(root.right, st);
        while(!st.isEmpty()){
            int top = st.pop();
            ans.add(top);
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
        System.out.println(boundaryTraversal(root));
    }
    
}
