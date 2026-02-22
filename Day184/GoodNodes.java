package Day184;
import java.util.*;
public class GoodNodes {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void helper(Node root,List<Integer> a){
        if(root == null) return;
        if(root.val >= a.get(a.size()-1)){
            a.add(root.val);
        }
        helper(root.left, a);
        helper(root.right, a);
    }
    static List<Integer> goodNodes(Node root){
        List<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        helper(root.left, arr);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(root.val);
        helper(root.right, arr2);
        arr2.remove(0);
        arr.addAll(arr2);
        return arr;

    }
    public static void main(String[] args) {
        Node root = new Node(3);
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(1);
        Node e = new Node(1);
        Node f = new Node(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(goodNodes(root));
    }
    
}
