package Day156;
import java.util.*;
public class RightView {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void helper(Node root,int level,List<Integer> ans){
        if(root == null) return;
        if(level == ans.size()) ans.add(root.val);
        helper(root.left, level+1, ans);
        helper(root.right, level+1, ans);
    }
    static List<Integer> rightView(Node root){
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
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
        System.out.println(rightView(root));
    }
    
}
