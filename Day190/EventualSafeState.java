package Day190;

import java.util.*;
public class EventualSafeState {
    static List<Integer> findSafeNodes(int[][] mat){
        int n = mat.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0;i<n;i++){
            for(int it: mat[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            arr.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(arr);
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        int[][] mat = new int[n][];
        for(int i = 0;i<n;i++){
            System.out.println("Enter columns");
            int m = sc.nextInt();
            mat[i] = new int[m];
            for(int j = 0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(findSafeNodes(mat));
        sc.close();
    }
    
}
