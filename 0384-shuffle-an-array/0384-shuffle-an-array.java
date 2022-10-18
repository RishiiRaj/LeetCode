import java.util.Random;
class Solution {
    
    private int[] nums;
    private Random r;
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if(nums == null) return null;
        int[] copy = nums.clone();
        for(int j = 1; j<copy.length; j++){
            int i = r.nextInt(j+1);
            swap(copy,i,j);
        }
        return copy;
    }
    private void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */