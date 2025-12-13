package Day130;

import java.util.*;

public class IterationUsingStack {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static List<Integer> postOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node node = st1.pop();
            st2.add(node);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while (st2.size()>0) {
            ans.add(st2.pop().val);
        }
        return ans;

    }
    static List<Integer> inOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) {
                    break;
                }
                else{
                    node = st.pop();
                    ans.add(node.val);
                    node = node.right;
                }
            }  
        }
        return ans;
    }
    static void preorder(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node top = st.peek();
            st.pop();
             if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
            System.out.print(top.val+" ");
            
        }
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
        preorder(root);
        System.out.println();
        System.out.println(inOrder(root));
        System.out.println();
        System.out.println(postOrder(root));
    }
    
}
