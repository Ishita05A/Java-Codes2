package Day133;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreeFormInPreOrder {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static Node build(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,HashMap<Integer,Integer> mp){
        if(preStart>preEnd || inStart>inEnd) return null;
        Node root = new Node(preOrder[preStart]);
        int inRoot = mp.get(root.val);
        int numleft = inRoot - inStart;
        root.left = build(preOrder, preStart+1, preStart+numleft, inOrder, inStart, inRoot-1, mp);
        root.right = build(preOrder, preStart+numleft+1, preEnd, inOrder, inRoot+1, inEnd, mp);
        return root;
    }
    static Node buildTree(int[] preOrder, int[] inOrder){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<inOrder.length;i++){
            mp.put(inOrder[i], i);
        }
        Node root = build(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1,mp);
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
        int[] preOrder = {10 ,20, 40,50,30,60};
        Node root = buildTree(preOrder, inorder);
        levelOrderq(root);


    }
    
}
