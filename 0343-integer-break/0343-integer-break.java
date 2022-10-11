class Solution {
    public int integerBreak(int n) {
        int[] dp =  new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int j = 2; j<=n;j++){
            int  maxi = 0;
            for(int i =1; i<j;i++){
                // copy the recurrence
                int breakk = dp[j-i]*i; // break furhter
                int not_break = (j-i)*i; // don't break any further
                maxi = Math.max(maxi,Math.max(breakk,not_break)); // store  the maxi
            }
            dp[j] = maxi;
        }
        return dp[n];
    }
    /*
    // recurrence  which was used in recursion approach
    private int f(int n, Integer[] dp){
        if(n==0 || n==1) return 1;
        
        if(dp[n] != null) return  dp[n];
        
        int maxi = 0;
        
        for(int i = 1; i<n; i++){
            int breakk = f(n-i,dp)*i; // break furhter
            int not_break = (n-i)*i; // don't break any further
            maxi = Math.max(maxi,Math.max(breakk,not_break)); // store  the maxi
        }
        return maxi;
    }
    */
}