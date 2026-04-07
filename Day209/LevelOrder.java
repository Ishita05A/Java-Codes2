package Day209;

public class LevelOrder {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        } 
    }
    static int height(Node root){
        if(root == null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
    static void levelOrder(Node root,int level){
        if(root == null) return;
        if(level == 1){
            System.out.print(root.val+" ");
        }
        else{
            levelOrder(root.left, level-1);
            levelOrder(root.right, level-1);
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        int height = height(root);
        for(int i = 1;i<=height;i++){
            levelOrder(root, i);
            System.out.println();
        }
    }
    
}
