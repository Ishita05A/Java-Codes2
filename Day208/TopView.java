package Day208;
import java.util.*;
public class TopView {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static class Pair{
        int line;
        Node node;
        Pair(int line,Node node){
            this.line = line;
            this.node = node;
        }
    }
    static void topView(Node root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, root));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while(!st.isEmpty()){
            Pair top = st.pop();
            Node node = top.node;
            int line = top.line;
            if(!mp.containsKey(line)){
                mp.put(line, node.val);
            }
            if(node.left != null) st.push(new Pair(line-1, node.left));
            if(node.right != null) st.push(new Pair(line+1, node.right));
        }
        for(var e:mp.entrySet()){
            System.out.print(e.getValue()+" ");
        }
    }
    static void bottomView(Node root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, root));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while(!st.isEmpty()){
            Pair top = st.pop();
            int line = top.line;
            Node node = top.node;
            mp.put(line, node.val);
            if(node.left != null) st.push(new Pair(line-1, node.left));
            if(node.right != null) st.push(new Pair(line+1, node.right));
        }
        for(var e:mp.entrySet()){
            System.out.print(e.getValue()+" ");
        }
    }
    static void rightView(Node root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, root));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while(!st.isEmpty()){
            Pair top = st.pop();
            Node node = top.node;
            int line = top.line;
            mp.put(line,node.val);
            
            if(node.right != null){
                st.push(new Pair(line+1, node.right));
            }
            else if(node.left != null){
                st.push(new Pair(line+1, node.left));
            }
        }
        for(var e:mp.entrySet()){
            System.out.print(e.getValue()+" ");
        }
    }
    static void leftView(Node root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, root));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while(!st.isEmpty()){
            Pair top = st.pop();
            Node node = top.node;
            int line = top.line;
            mp.put(line,node.val);
            if(node.left != null){
                st.push(new Pair(line+1, node.left));
            }
            else if(node.right != null){
                st.push(new Pair(line+1, node.right));
            }
        }
        for(var e:mp.entrySet()){
            System.out.print(e.getValue()+" ");
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        topView(root);
        System.out.println();
        bottomView(root);
        System.out.println();
        rightView(root);
        System.out.println();
        leftView(root);
    }
    
}
