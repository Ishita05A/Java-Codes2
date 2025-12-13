package Day130;
import java.util.*;
public class traversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static List<List<Integer>> levelOrderAL(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            List<Integer> a = new ArrayList<>();
            int size = q.size();
            while(size>0){
                Node top = q.peek();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                a.add(top.val);
                q.remove();
                size--;
            }
            ans.add(a);
        } 
        return ans;
    }
    static void levelOrderq(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.element();
            System.out.print(top.val+" ");
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
            q.remove();
        }
    }
    static List<Integer> levelOrder(Node root,int n,List<Integer> ans){
        if(root == null || n<1) return new ArrayList<>();
        if(n == 1)
            ans.add(root.val);
        levelOrder(root.left, n-1, ans);
        levelOrder(root.right, n-1, ans);
        return ans;
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
         System.out.print(root.val+" ");
    }
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
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
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        levelOrderq(root);
        System.out.println();
        List<List<Integer>> ans = levelOrderAL(root);
        System.out.println(ans);   





    }
    
}
