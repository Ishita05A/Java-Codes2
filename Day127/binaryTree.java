package Day127;

public class binaryTree {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static int sum(Node root){
        if(root == null) return 0;
        return root.val + sum(root.left)+sum(root.right);
    }
    static int findSize(Node root){
        if(root == null) return 0;
        return 1+ findSize(root.left)+findSize(root.right);
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    static int findHeight(Node root){
        if(root == null) return 0;
        return 1 +Math.max(findHeight(root.left), findHeight(root.right));
    }
    static int edgeHeight(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1+Math.max(edgeHeight(root.left), edgeHeight(root.right));
    }
    static int findMax(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(findMax(root.left), findMax(root.right)) );
    }

    static void nthLevel(Node root ,int n){
        if(root == null) return;
        if(n == 1) System.out.print(root.val+" ");
        nthLevel(root.left, n-1);
        nthLevel(root.right, n-1);
    }
    static void display1(Node root){
        if(root == null) {
            
            return;
        }
        System.out.print(root.val+" -> ");
        if(root.left != null) System.out.print(root.left.val+" "); else System.out.print("n ");
        if(root.right != null) System.out.print(root.right.val); else System.out.print("n ");
        System.out.println();
        display1(root.left);
        display1(root.right);
    }
    static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        display(root);
        System.out.println();
        System.out.println(findSize(root));
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(sum(root));
        display1(root);
        System.out.println(findMax(root));
        System.out.println(findHeight(root));
        System.out.println(edgeHeight(root));
        nthLevel(root, 2);

    }
    
}
