class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return f(0,nums,dp);
    }
    public int f(int index, int[] nums,int[] dp){
        if(index >= nums.length-1)
            return 0;
        
        if(dp[index] != -1) return dp[index];
        int min = (int)Math.pow(10,9);
        // try all possibilities from index+1 to the index+jump value
        // value on that index tells how far we can jump
        for(int  i = index+1;i<=index+nums[index];i++){
            int jump = 1+f(i,nums,dp);
            min = Math.min(min,jump);
        }
        return dp[index] = min;
    }
}