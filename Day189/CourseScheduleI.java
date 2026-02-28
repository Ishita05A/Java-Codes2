package Day189;
import java.util.*;

public class CourseScheduleI {
    static boolean canFinish(int[][] mat,int v){
        List<List<Integer>> adj = new ArrayList<>();
        int n = mat.length;
        for(int i= 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[v];
        for(int i = 0;i<n;i++){
            adj.get(mat[i][1]).add(mat[i][0]);
            indegree[mat[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<v;i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            arr.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return arr.size() == v;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int n = sc.nextInt();
        System.out.println("Enter no. of columns");
        int m = sc.nextInt();
        System.out.println("Enter elements ");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(canFinish(arr,4));
        sc.close();
    }
    
}
