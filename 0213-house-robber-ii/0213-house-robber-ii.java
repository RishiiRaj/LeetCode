// get ont answer by leaving last element of nums
// get another answer by leaving first element of nums
// return the max of both
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        int[][] dp = new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);
        
        int one = f(1, n-1,nums,dp);
        int two = f(0, n-2,nums,dp);
        return Math.max(one,two);
    }
    // instead of using 0 as out edge case, we use a variable
    public int f(int start, int index, int[] nums, int[][] dp){
        if(index < start) return 0;
        if(dp[index][start] != -1) return dp[index][start];
        int take = nums[index] + f(start,index-2,nums,dp);
        int not_take = f(start,index-1,nums,dp);
        
        return dp[index][start] = Math.max(take,not_take);
    }
}