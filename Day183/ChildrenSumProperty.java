package Day183;

public class ChildrenSumProperty {
     
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+"->" );
        if(root.left != null) System.out.print(root.left.val+" "); else System.out.print("n ");
        if(root.right != null) System.out.print(root.right.val+" "); else System.out.print("n ");
        System.out.println();
        display(root.left);
        display(root.right);
    }
    static void childSumProperty(Node root){
        if(root == null) return;
        int sum = 0;
        if(root.left != null) sum+=root.left.val;
        if(root.right != null) sum+=root.right.val;
        if(root.val > sum){
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }
        else{
            root.val = sum;
        }
        childSumProperty(root.left);
        childSumProperty(root.right);
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
        childSumProperty(root);
        System.out.println();
        display(root);
    }
    
}
