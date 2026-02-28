package Day189;
import java.util.*;
public class DetectACycleDFS {
    static boolean isCyclic(List<List<Integer>> adj,int v){
        List<Integer> arr = new ArrayList<>();
        int[] indegree = new int[v+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<=v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0;i<=v;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            arr.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return arr.size() != adj.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        System.out.println(isCyclic(adj, n));
        sc.close();
    }
    
}
