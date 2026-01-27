package Day164;
import java.util.*;
public class Adjecentmatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of Edges");
        int m = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            ans.add(new ArrayList<>());
        }
        for(int j = 0;j<m;j++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        // for(int i = 0;i<n;i++){
        //     for(int j = 0; j<ans.get(i).size();j++){
        //         System.out.println(ans.get(n));
        //     }
        // }
        System.out.println(ans);
        sc.close();

    }
    
}
