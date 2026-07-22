package Day231;
import java.util.LinkedList;
import java.util.Queue;

public class ChildSumProperty {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    static void display(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node top = q.poll();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                System.out.print(top.val+" ");
            }
            System.out.println();

        } 
    }

    static void childSum(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left != null) child+=root.left.val;
        if(root.right != null) child+=root.right.val;
        if(child>=root.val){
            root.val = child;
        }
        else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }
        childSum(root.left);
        childSum(root.right);
        int tot = 0;
        if(root.left != null) tot+=root.left.val;
        if(root.right != null) tot+=root.right.val;
        if(root.left != null || root.right != null) root.val = tot;
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
        display(root);
        childSum(root);
        display(root);
    }

}