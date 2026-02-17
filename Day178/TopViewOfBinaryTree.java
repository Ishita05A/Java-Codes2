package Day178;

import java.util.*;
public class TopViewOfBinaryTree {
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
        Pair(int line,Node node){
            this.node = node;
            this.line = line;
        }
    }
    static List<Integer> topView(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        TreeMap<Integer,Node> mp = new TreeMap<>();
        st.push(new Pair(0, root));
        while(!st.empty()){
            Pair top = st.pop();
            int line = top.line;
            Node node = top.node;
            if(!mp.containsKey(line)){
                mp.put(line, node);
            }
            if(node.left != null) st.push(new Pair(line-1, node.left));
            if(node.right != null) st.push(new Pair(line+1, node.right));
        }
        for(var e : mp.entrySet()){
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
