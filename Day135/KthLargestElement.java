package Day135;

public class KthLargestElement {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static int numberOfNodes(Node root){
        if(root == null) return 0;
        return 1+numberOfNodes(root.left)+numberOfNodes(root.right);
    }
    static int kthLargest(Node root,int key){
        int n = numberOfNodes(root);
        key = n-key+1;
        int count = 0;
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == key) return curr.val;
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr) prev = prev.right;
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    count++;
                    if(count == key) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        Node a = new Node(5);
        Node b = new Node(12);
        Node c = new Node(4);
        Node d = new Node(7);
        Node e = new Node(10);
        Node f = new Node(14);
        Node g = new Node(6);
        Node h = new Node(13);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        f.left = h;
        System.out.println(kthLargest(root, 3));
        
    }
    
}
