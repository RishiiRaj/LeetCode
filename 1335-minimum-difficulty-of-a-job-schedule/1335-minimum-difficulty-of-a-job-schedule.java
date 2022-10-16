// divide the array into d subarrays, and minimize the sum of largest elements on all d subarrays
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if(len<d) return -1;
        Integer[][] dp = new Integer[len][d+1];
        return f(d, 0, jobDifficulty, dp);
    }
    private int f(int d, int len, int[] jobDifficulty, Integer[][] dp){
        int n = jobDifficulty.length;
        // base conditions
        if(d == 0 && len == n) return 0; // no cuts left and reached end of array
        if(d == 0 || len == n) return Integer.MAX_VALUE; // either of 2 conditions to avoid things later
        // memoization
        if(dp[len][d] != null) return dp[len][d];
        
        // logic
        int currMax = jobDifficulty[len];
        int mini = Integer.MAX_VALUE;
        
        for(int i = len; i<n; i++){
            currMax = Math.max(currMax, jobDifficulty[i]); // maximum till now
            int temp = f(d-1,i+1,jobDifficulty,dp); // max of rest of  the array using recursion
            if(temp != Integer.MAX_VALUE){ // if max exists
                mini = Math.min(mini,temp+currMax); // find min of sum of all maximums
            }
        }
        return dp[len][d] = mini;
    }
}