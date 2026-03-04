package Day192;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static int findMinMultipication(int[] arr,int st,int end){
        int[] dist = new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(st, 0));
        int mod = 100000;
        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.first;
            int step  = top.second;
            for(int it: arr){
                int adjNode = (node*it)%mod ;
                if(adjNode == end) return step+1;
                if(step+1<dist[adjNode]){
                    dist[adjNode] = step+1;
                    q.add(new Pair(adjNode, step+1));
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        System.out.println(findMinMultipication(arr, 3, 30));
    }
}
