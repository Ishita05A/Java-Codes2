package Day156;
import java.util.*;
public class topView {
    static class Node{
        Node left;
        Node right;
        int val;
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
    static List<Integer> top_view(Node root){
        Stack<Pair> st = new Stack<>();
        List<Integer> ans =new ArrayList<>();
        TreeMap<Integer,Node> mp = new TreeMap<>();
        st.push(new Pair(0, root));
        while(!st.isEmpty()){
            Pair top = st.pop();
            if(!mp.containsKey(top.line)){
                mp.put(top.line, top.node);
            }
            if(top.node.left != null) st.push(new Pair(top.line-1, top.node.left));
            if(top.node.right != null) st.push(new Pair(top.line+1, top.node.right));
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
        System.out.println(top_view(root));
    }
    
}
