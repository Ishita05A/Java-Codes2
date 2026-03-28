package Day204;

import java.util.*;
public class KahnAlgo {

    static List<Integer> kahnAlgo(List<List<Integer>> adj,int v){
        int[] indegree = new int[v];
        for(int i = 0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Stack<Integer> st = new Stack<>();
        for(int i =0 ;i<v;i++){
            if(indegree[i] == 0){
                st.push(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            int node =  st.pop();
            ans.add(node);
            for(int it :adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    st.push(it);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter nodes");
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        System.out.println(kahnAlgo(adj, n));
        sc.close();
    }
}
