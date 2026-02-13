package Day172;

import java.util.ArrayList;
import java.util.Stack;
import java.util.*;
public class IterativePostOrder {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void postOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Stack<Node> st1 = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.pop();
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
            st1.push(top);
        }
        while(!st1.isEmpty()){
            ans.add(st1.pop().val);
        }
        System.out.println(ans);

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
        postOrder(root);
    }
    
}
