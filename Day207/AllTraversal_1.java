package Day207;
import java.util.*;
public class AllTraversal_1 {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static class Pair{
        Node node;
        int t;
        Pair(Node node,int t){
            this.node = node;
            this.t = t;
        }
    }
    static List<List<Integer>> all_Traversal(Node root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()){
            Pair top = st.pop();
            Node node = top.node;
            int t = top.t;
            if(t == 1){
                pre.add(node.val);
                st.push(new Pair(node, t+1));
                if(node.left != null){
                    st.push(new Pair(node.left,1));
                } 
            }
            else if(t == 2){
                in.add(node.val);
                st.push(new Pair(node, t+1));
                if(node.right != null){
                    st.push(new Pair(node.right, 1));
                }
            }
            else {
                post.add(node.val);
            }
        }
        ans.add(pre);
        ans.add(in);
        ans.add(post);
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
        System.out.println(all_Traversal(root));
    }
    
}
