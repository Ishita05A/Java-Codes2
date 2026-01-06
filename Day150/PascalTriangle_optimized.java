package Day150;
import java.util.*;
public class PascalTriangle_optimized {

    static List<Integer> generateRows(int rows){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        int ans = 1;
        for(int i = 1;i<rows;i++){
            ans*=(rows-i);
            ans/=i;
            a.add(ans);
        }
        return a;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<=5;i++){
            ans.add(generateRows(i));
        }
        System.out.println(ans);
    }
    
}
