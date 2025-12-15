package Day131;
import java.util.*;
public class zigZagOrder {
    
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    static void leftToRight(Node root,int n,List<Integer> a){
        if(root == null) return;
        if(n==1) a.add(root.val);
        leftToRight(root.left, n-1, a);
        leftToRight(root.right, n-1, a);
    }
    static void rightToLeft(Node root,int n,List<Integer> a){
        if(root == null) return;
        if(n == 1) a.add(root.val);
        rightToLeft(root.right, n-1, a);
        rightToLeft(root.right, n-1, a);
    }
    static List<List<Integer>> printZigZag(Node root){
        if(root == null) return new ArrayList<>();
        Queue<Node> st = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        st.add(root);
        boolean flag = true;
        while(!st.isEmpty()){
            List<Integer> a = new ArrayList<>();
            int size = st.size();
            
            while(size>0){
                Node temp = st.remove();
                if(temp.left != null) st.add(temp.left);
                if(temp.right != null) st.add(temp.right);
                a.add(temp.val);
                size--;
            }
            if(flag == true){
                ans.add(a);
                flag = false;
            }
            else{
                Collections.reverse(a);
                ans.add(a);
                flag = true;
            }
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
        List<List<Integer>> ans = printZigZag(root);
        System.out.println(ans);
    }
    
}
