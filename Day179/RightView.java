package Day179;
import java.util.*;
public class RightView {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    
    static class Pair{
        int level;
        Node node;
        Pair(int level,Node node){
            this.level = level;
            this.node = node;
        }
    }
    static void leftView(Node root){
        TreeMap<Integer,Node> mp = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, root));
        while(!st.isEmpty()){
            Pair top = st.pop();
            int level = top.level;
            Node node = top.node;
            if(!mp.containsKey(level)){
                mp.put(level, node);
            }
            if(node.right != null) st.push(new Pair(level+1, node.right));
            if(node.left != null) st.push(new Pair(level+1, node.left));
            
        }
        for(var e:mp.entrySet()){
            ans.add(e.getValue().val);
        }
        System.out.println(ans);
    }
    static void rightView(Node root){
        TreeMap<Integer,Node> mp = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, root));
        while(!st.isEmpty()){
            Pair top = st.pop();
            int level = top.level;
            Node node = top.node;
            if(!mp.containsKey(level)){
                mp.put(level, node);
            }
            if(node.left != null) st.push(new Pair(level+1, node.left));
            if(node.right != null) st.push(new Pair(level+1, node.right));
        }
        for(var e:mp.entrySet()){
            ans.add(e.getValue().val);
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
        rightView(root);
        leftView(root);

    }
    
}
