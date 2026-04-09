package Day210;
import java.util.*;
class RootToLeaf {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static boolean rootToLeaf(Node root,Node target,List<Integer> path){
        if(root == null) return false;
        path.add(root.val);
        if(root == target) return true;
        if((rootToLeaf(root.left, target, path) || rootToLeaf(root.right, target, path)) == true) return true;
        path.remove(path.size()-1);
        return false;
    }
    static List<Integer> Path(Node root,Node target){
        List<Integer> a = new ArrayList<>();
        rootToLeaf(root, target, a);
        return a;
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
        System.out.println(Path(root, e));
    }
}