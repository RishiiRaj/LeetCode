class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid[0].length;
        
        int[] ans = new int[m];
        for(int j = 0; j<m;j++){
            ans[j] = find(grid,0,j);
        }
        return ans;
    }
    // DFS
    private int find(int[][] grid, int i, int j){
        if(i==grid.length) return  j; // reached the bottom of the grid
        
        if(j<0 || j>grid[0].length) return -1; // ball fell to out  from left or right
        
        // if it's not forming a 'V'
        if(grid[i][j] == 1 && j+1<grid[0].length && grid[i][j+1] == 1){
            return find(grid,i+1,j+1);
        }
        // if its not forming a 'V'
        if(grid[i][j] == -1 && j-1 >= 0 && grid[i][j-1] == -1){
            return  find(grid,i+1,j-1);
        }
        // else return -1
        return -1;
    }
}