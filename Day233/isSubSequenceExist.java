public class isSubSequenceExist {

    static boolean helper(int[] a, int idx, int k){
        if(idx == a.length || k < 0) return false;
        if(k == a[idx] ) return true;
        return helper(a, idx+1, k) || helper(a, idx+1, k-a[idx]);  
    }
    static boolean subSequence(int[] a,int k){
        return helper(a, 0, k);
    }
    public static void main(String[] args) {
        int[]  nums = {4, 3, 9, 2};
        System.out.println(subSequence(nums, 10));
    }
    
}
