class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // converting list of list to grid
        int[][] tri = new int[triangle.size()][triangle.size()];
        int row = 0, col = 0;
        for(List<Integer> rowz : triangle){
            for(int i : rowz){
                tri[row][col++] = i;
            }
            row++;
            col=0;
        }
        // for(int i = 0; i<triangle.size(); i++){
        //     for(int  j = 0; j<triangle.size();j++){
        //         System.out.print(tri[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] haha : dp){
            Arrays.fill(haha,-1);
        }
        return f(0,0,tri,dp);
    }
    public int f(int i, int j, int[][] triangle, int[][] dp){
        int n = triangle.length;
        // base case
        if(i==n-1) return dp[i][j] = triangle[n-1][j];
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int down = triangle[i][j] + f(i+1,j,triangle,dp);
        int diag = triangle[i][j] + f(i+1,j+1,triangle,dp);
        
        return dp[i][j] = Math.min(down, diag);
    }
}