class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        Integer[][] dp = new Integer[101][101];
        return dfs(s,0,k,dp);
    }
    private int dfs(String s, int left, int K, Integer[][] dp) {
        int k = K;
        // base case
        if(s.length() - left <= k) return 0;
        // memoization
        if(dp[left][k] != null) return dp[left][k];
        // logic (samaj ni aaya)
        int res = k!=0 ? dfs(s, left + 1, k - 1,dp) : 10000, c = 1;
        for(int i = left + 1; i <= s.length(); ++i) {
            res = Math.min(res, dfs(s, i, k,dp) + 1 + (c >= 100 ? 3 : (c >= 10 ? 2 : (c > 1 ? 1 :0))));
            if(i == s.length()) break;
            if(s.charAt(i) == s.charAt(left)) ++c;
            else if(--k < 0) break;
        }
        return dp[left][K] = res;
    }
}