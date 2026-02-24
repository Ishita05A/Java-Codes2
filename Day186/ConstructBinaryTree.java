package Day186;
import java.util.*;
public class ConstructBinaryTree {

    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
        static Node construct_BT(int[] pre,int preSt,int preEnd,int[] inOrder,int inst,int inend){
            if(preSt>preEnd || inst > inend){
                return null;
            }
            Node root = new Node(pre[preSt]);
            int inroot = 0;
            for(int i = inst;i<inend;i++){
                if(inOrder[i] == pre[preSt]){
                    inroot = i;
                    break;
                }
            }
            int leftSize = inroot-inst;
            root.left = construct_BT(pre, preSt, preSt-leftSize, inOrder, inst, leftSize-1);
            root.right = construct_BT(pre, leftSize+1, preEnd, inOrder, leftSize+1, inend);
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    
}