package Day183;

public class IsUniqueBTPossible {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static boolean isConstructionPossible(int a,int b){
        if(a == 2 || b == 2) return true;
        return false;
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
        System.out.println(isConstructionPossible(1, 3));
        System.out.println(isConstructionPossible(1, 2));
    }
    
}
