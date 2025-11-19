package Day119;

public class FindNodewithMaxAndMin {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int findMin(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(findMin(root.left), findMin(root.right)));
    }
    static int findMax(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(findMax(root.left), findMax(root.right)));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c= new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(findMax(root));
        System.out.println(findMin(root));
    }
    
}
