package Day230;
import java.util.*;
public class BoundaryTraversal {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    static void leftTraversal(Node root, List<Integer> ans){
        if(root == null || (root.left == null && root.right == null)) return;
        ans.add(root.val);
        if(root.left != null) leftTraversal(root.left, ans);
        else leftTraversal(root.right, ans);
    }
    static void bottomTraversal(Node root, List<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.val);
        bottomTraversal(root.left, ans);
        bottomTraversal(root.right, ans);
    }
    static void rightTraversal(Node root,Stack<Integer> st ){
        if(root == null || (root.left == null && root.right == null)) return;
        st.push(root.val);
        if(root.right != null) rightTraversal(root.right, st);
        else rightTraversal(root.right, st);

    }

    static List<Integer> boundaryTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        leftTraversal(root.left, ans);
        bottomTraversal(root, ans);
        Stack<Integer> st = new Stack<>();
        rightTraversal(root.right, st);
        while (!st.isEmpty()){
            ans.add(st.pop());
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
