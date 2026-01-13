package Day154;

import java.util.ArrayList;
import java.util.*;
public class AllTraversal {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static class Pair{
        Node node;
        int time;
        Pair(Node node,int time){
            this.node = node;
            this.time = time;
        }
    }
    static List<List<Integer>> all_Traversal(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root ,1));
        while(!st.isEmpty()){
            Pair top = st.pop();
            if(top.time == 1){ 
                preOrder.add(top.node.val);
                st.push(new Pair(top.node, top.time+1));
                if(top.node.left != null) st.push(new Pair(top.node.left, 1));
            }
            else if(top.time == 2) {
                inOrder.add(top.node.val);
                st.push(new Pair(top.node, top.time+1));
                if(top.node.right != null) st.push(new Pair(top.node.right, 1));
            }
            else if(top.time == 3){
                postOrder.add(top.node.val);
            }
        }
        ans.add(preOrder);
        ans.add(inOrder);
        ans.add(postOrder);
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
