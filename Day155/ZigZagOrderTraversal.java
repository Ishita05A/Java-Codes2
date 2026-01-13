package Day155;
import java.util.*;
public class ZigZagOrderTraversal {
     static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+ Math.max(height(root.left), height(root.right));
    }
    static void zigZag(Node root,int n,List<Integer> ans){
        if(root == null) return;
        if(n == 1) ans.add(root.val);
        zigZag(root.left, n-1,ans);
        zigZag(root.right, n-1,ans);
    
    }
    static void zigZag2(Node root,int n,List<Integer> ans){
        if(root == null) return;
        if(n == 1) ans.add(root.val);
        zigZag2(root.right, n-1,ans);
        zigZag2(root.left, n-1,ans);
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
        int height = height(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<=height;i++){
            List<Integer> aaa = new ArrayList<>();
            if(i%2 == 0)  zigZag2(root, i,aaa);
            else zigZag(root, i,aaa);
            ans.add(aaa);
        }
        System.out.println(ans);
    }
    
}
