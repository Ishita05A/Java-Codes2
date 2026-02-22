package Day184;
import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void leafNodes(Node root,List<Integer> arr){
        if(root == null) return;
        if(root.left == null && root.right == null){
            arr.add(root.val);
            return;
        }
        leafNodes(root.left,arr);
        leafNodes(root.right,arr);
    }
    static void leaf_similar(Node root1,Node root2){
        List<Integer> a = new ArrayList<>();
        leafNodes(root1,a);
        System.out.println(a);
        List<Integer> b = new ArrayList<>();
        leafNodes(root2,b);
        System.out.println(b);
        System.out.println(a.equals(b));
        
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

        Node root2 = new Node(1);
        Node u = new Node(2);
        Node v = new Node(3);
        Node w = new Node(4);
        Node x = new Node(5);
        Node y = new Node(6);
        Node z = new Node(7);
        root2.left = u;
        root2.right = v;
        u.left = w;
        u.right = x;
        v.left = y;
        v.right = z;
        leaf_similar(root, root2);
    }
    
}
