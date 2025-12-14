package Day131;

import java.util.ArrayList;
import java.util.*;


public class PostOrder {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static List<Integer> postorder(Node root){
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.peek();
                    st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }
                else{
                    root = temp;
                }
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
        System.out.println(postorder(root));
    }
    
}
