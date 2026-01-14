package Day155;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class VerticalOrderTraversal {
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
        int line;
        Pair(Node node,int line){
            this.node = node;
            this.line = line;
        }
    }
    static List<Integer> topView(Node root){
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Node> mp = new TreeMap<>();
        Stack<Pair> st =new Stack<>();
        st.push(new Pair(root, 0));
        while(!st.isEmpty()){
            Pair top = st.pop();
            if(!mp.containsKey(top.line)) mp.put(top.line, top.node);
            if(top.node.left != null) st.push(new Pair(top.node.left, top.line-1));
            if(top.node.right!= null) st.push(new Pair(top.node.right, top.line+1));
        }
        for( var e:mp.entrySet()){
            ans.add(e.getValue().val);
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(topView(root));
    }
    
}
