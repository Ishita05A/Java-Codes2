package Day159;
import java.util.*;
public class PrintRootToLeafPath {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isPathPresent(Node root,Node target,List<Integer> ans){
        if(root == null) return false;
        ans.add(root.val);
        if(root == target) return true;
        if( isPathPresent(root.left, target, ans) || isPathPresent(root.right, target, ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    static List<Integer> rootToLeaf(Node root,Node target){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        isPathPresent(root, target, ans);
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);        
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(4);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(rootToLeaf(root, f));
    }
    
}
