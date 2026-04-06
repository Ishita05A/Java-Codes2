package Day209;

import java.util.LinkedList;
import java.util.*;
public class ChildrenSumProperty {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size =q.size();
            for(int i = 0;i<size;i++){
                Node top = q.poll();
                System.out.print(top.val+" ");
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right); 
                
            }
            System.out.println();
        }
    }
    static void childSumProp(Node root){
        if(root == null) return ;
        int child = 0;
        if(root.left != null){
            child+=root.left.val;
        }
        if(root.right != null){
            child+=root.right.val;
        }
        if(child>=root.val) root.val= child;
        else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }
        childSumProp(root.left);
        childSumProp(root.right);
        int tot = 0;
        if(root.left != null) tot+=root.left.val;
        if(root.right != null) tot+=root.right.val;
        if(root.left != null || root.right != null) root.val = tot;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(35);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(5);
        Node f = new Node(2);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        levelOrder(root);
        childSumProp(root);
        levelOrder(root);
    }
    
}
