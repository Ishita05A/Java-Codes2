package Day153;
import java.util.*;

public class FindPairSum {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    static List<List<Integer>> findPairSum(Node head,int k){
        
        Node right = head;
        Node left = head;
        while(right.next != null){
            right = right.next;
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(left != null && right != null && left != right && right.next != left){
            List<Integer> a = new ArrayList<>();
            int sum = left.data+right.data;
            if(sum>k){
                right = right.prev;
            }else if(sum<k){
                left = left.next;
            }
            else if(sum ==k){
                a.add(left.data);
                a.add(right.data);
                left = left.next;
                right = right.prev;
                ans.add(a);
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.prev = a;

        b.next = c;
        c.prev = b;

        c.next = d;
        d.prev = c;
        System.out.println(findPairSum(a, 5));
        
    }
    
}
