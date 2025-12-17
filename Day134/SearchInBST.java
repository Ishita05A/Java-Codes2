package Day134;

public class SearchInBST {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static Node search(Node root, int val){
        while(root!= null && root.val != val){
            root = val<root.val ? root.left : root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        Node a = new Node(5);
        Node b = new Node(12);
        Node c= new Node(4);
        Node d = new Node(7);
        Node e = new Node(10);
        Node f = new Node(14);
        Node g = new Node(6);
        Node h = new Node(13);
        root.left = a;
        root.right = b;
        a.left = c;
        a.left = d;
        b.left = e;
        b.right = f;
        d.left = g;
        f.left = h;
        System.out.println(search(root, 10).val);
    

    }
    
}
