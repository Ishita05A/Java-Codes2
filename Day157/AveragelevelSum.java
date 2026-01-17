package Day157;
import java.util.*;
public class AveragelevelSum {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static List<Double> average_level(Node root){
        List<Double> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for(int i = 1;i<=size;i++){
                Node top = q.poll();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                sum+=top.val;
            }
            ans.add(sum/size);
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
        System.out.println(average_level(root));
        
    }
    
}
