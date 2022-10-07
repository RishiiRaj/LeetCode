class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp array to memoize
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        int start_from_last = f(n-1,cost,dp); // when we start from the last index
        int start_from_second_last = f(n-2,cost,dp); // when we start from the 2nd last  index
        
        return Math.min(start_from_last,start_from_second_last); // return the minimum
    }
    private int f(int index, int[] cost, int[] dp){
        if(index < 0) return dp[index] = 0;
        if(index == 0 || index == 1) return dp[index] = cost[index];
        
        if(dp[index] != -1) return dp[index];
        
        int one = cost[index] + f(index-1, cost, dp);
        int two = cost[index] + f(index-2, cost, dp);
            
        return dp[index] = Math.min(one,two);
    }
}