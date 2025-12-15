package Day132;
import java.util.*;


public class findTargetPath {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static boolean getPath(Node root,int target,List<Integer> ans){
        if(root == null) return false;
        ans.add(root.val);
        if(root.val == target) return true;
        if(getPath(root.left, target, ans) || getPath(root.right, target, ans)) return true;
        ans.remove(ans.size()-1);
        return false;

    }
    static List<Integer> targetPath(Node root,int target){
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        getPath(root, target, ans);
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = g;
        b.left = e;
        b.right = f;
        f.left = h;
        f.right = i;
        System.out.println(targetPath(root, 7));
    }
    
}
