package Day213;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Day213.MinumumMultiplication.Pair;

public class MinumumMultiplication {
    static class Pair{
        int node;
        int step;
        Pair(int node, int step){
            this.node = node;
            this.step = step;
        }
    }
    static int minSet(int[] arr,int st,int end){
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[100000];
        Arrays.fill(dist,100000);
        int mod = 100000;
        q.add(new Pair(st, 0));
        dist[st] = 0;
        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.node;
            int step = top.step;
            if(node == end) return step;
            for(int i = 0;i<arr.length;i++){
                int adjNode = (node*arr[i])%mod;
            
                if(step+1 < dist[adjNode]){
                    dist[adjNode] = step+1;
                    q.add(new Pair(adjNode, step+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;
        System.out.println(minSet(arr, start, end));
    }
    
}
