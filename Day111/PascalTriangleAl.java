package Day111;

import java.util.*;

public class PascalTriangleAl {
    static ArrayList<Integer> generateRow(int row){
        ArrayList<Integer> a = new ArrayList<>();
        int res = 1;
        a.add(1);
        for(int col = 1;col <row;col++){
            res = res*(row-col);
            res = res/col;
            a.add(res);
        }
        return a;

    }
    static List<List<Integer>> pascalTri(int row){
        List<List<Integer>> ans = new ArrayList<>();
        for(int col = 1;col<=row;col++){
            ArrayList<Integer> a = generateRow(col);
            ans.add(a);
            
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int row = sc.nextInt();
        List<List<Integer>> ans = pascalTri(row);
        System.out.println(ans);
        sc.close();
    }
    
}
