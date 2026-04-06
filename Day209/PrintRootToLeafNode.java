package Day209;
import java.util.*;
public class PrintRootToLeafNode {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static boolean helper(Node root,Node node,List<Integer> path){
        if(root ==  null) return false;
        path.add(root.val);
        if(root == node) return true;
        if((helper(root.left, node, path)  || helper(root.right, node, path) ) == true) return true;
        path.remove(path.size()-1);
        return false;
     }
    static List<Integer> rootToLeaf(Node root,Node node){
        List<Integer> ans = new ArrayList<>();
        helper(root, node, ans);
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
        System.out.println(rootToLeaf(root, e));


    }
    
}
