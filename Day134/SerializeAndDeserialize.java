package Day134;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static String serialize(Node root){
        StringBuilder str = new StringBuilder("");
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        str.append(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                Node top = q.poll();
                if(top.left != null) {
                    str.append(top.left.val);
                    q.add(top.left);
                }
                else str.append('n');
                if(top.right != null){
                    str.append(top.right.val);
                    q.add(top.right);
                }
                else str.append('n');
                size--;
            }
        }
        return str.toString();
    }
    static Node deserialize(String str){
        String[] values = str.split("");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1;i<values.length-1;i++){
            Node parent = q.poll();
            if(!values[i].equals("n")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
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
        String str =  serialize(root);
        System.out.println(str);
        Node parent = deserialize(str);
        levelOrderq(parent);
        

    }
    
}
