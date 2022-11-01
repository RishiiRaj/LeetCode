class Solution {
    public int rob(int[] nums) {
        // memoization array
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return f(nums,nums.length-1,dp);
    }
    public  int f(int[] nums, int index,int[] dp){
        if(index < 0) return 0;
        // memoization
        if(dp[index] != -1) return dp[index];
        int even = f(nums,index-2,dp)+nums[index];
        int odd = f(nums,index-1,dp);
        
        return dp[index]=Math.max(even, odd);
    }
}