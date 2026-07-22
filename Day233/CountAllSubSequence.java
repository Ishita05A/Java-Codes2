
public class CountAllSubSequence {
    static void helper(int[] a,int idx, int[] ans,int target){
        if(idx == a.length || target < 0) return;
        if(target == a[idx]){
            ans[0]++;
            return;
        }
        helper(a, idx+1, ans, target);
        if(target-a[idx] >=0) helper(a, idx+1, ans, target-a[idx]);
    }
    static int countSub(int[] a,int target){
        int[] ans = {0};
        helper(a, 0, ans, target);
        return ans[0];

    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 10, 5, 1, 3};
        System.out.println(countSub(nums, 5));
    }
    
}
