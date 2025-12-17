package Day134;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;

public class BTFrompostIn {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static Node build(int[] postOrder,int ps,int pe,int[] inOrder, int is, int ie,HashMap<Integer,Integer> mp){
        if(ps>pe || is>ie) return null;
        Node root = new Node(postOrder[pe]);
        int inroot = mp.get(root.val);
        int numleft = inroot-is;
        root.left = build(postOrder, ps, ps+numleft-1, inOrder, is, inroot-1, mp);
        root.right = build(postOrder, ps+numleft, pe-1, inOrder, inroot+1, ie, mp);
        return root;
    }
    static Node buildTree(int[] postOrder,int[] inOrder){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<postOrder.length;i++){
            mp.put(inOrder[i], i);
        }
        Node root = build(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1, mp);
        return root;
    }
    static void levelOrderq(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.element();
            System.out.print(top.val+" ");
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
            q.remove();
        }
    }
    public static void main(String[] args) {
        int[] inorder = {40,20,50,10,60,30};
        int[] postOrder = {40 ,50, 20,60,30,10};
        Node root = buildTree(postOrder, inorder);
        levelOrderq(root);
    }
    
}
