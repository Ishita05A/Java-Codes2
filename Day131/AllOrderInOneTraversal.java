package Day131;

import java.util.ArrayList;
import java.util.*;

public class AllOrderInOneTraversal {
    static class Pair{
        Node temp;
        int num;
        Pair(Node temp,int num){
            this.temp = temp;
            this.num = num;
        }
    }
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static List<List<Integer>> allTraversal(Node root){
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair it = st.pop();
            if(it.num == 1){
                preorder.add(it.temp.val);
                it.num++;
                st.push(new Pair(it.temp,it.num));
                if(it.temp.left != null) st.push(new Pair(it.temp.left,1));
            }
            else if(it.num == 2){
                inorder.add(it.temp.val);
                it.num++;
                st.push(new Pair(it.temp,it.num));
                if(it.temp.right != null) st.push(new Pair(it.temp.right, 1));

            }
            else{
                postorder.add(it.temp.val);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(preorder);
        ans.add(inorder);
        ans.add(postorder);
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
        List<List<Integer>> ans = allTraversal(root);
        System.out.println(ans);
    }
    
}
