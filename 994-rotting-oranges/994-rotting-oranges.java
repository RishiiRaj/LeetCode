class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int oranges = 0;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                // if rotten oranges found, add it to the  queue
                if(grid[i][j]==2) queue.offer(new int[]{i,j});
                // just count the number of oranges
                if(grid[i][j] !=0) oranges++;
            }
        }
        
        if(oranges == 0) return 0; // if there are no oranges
        int minutes = 0, count = 0;
        int[] dx = {0,0,1,-1}; // x direction movement
        int[] dy = {1,-1,0,0}; // y direction movement
        
        // bfs starting from initially rotten oranges
        while(!queue.isEmpty()){
            int size = queue.size(); // current size of queue
            count += size; // no. of rotten oranges according to queue
            
            for(int i = 0;i<size;i++){
                // for every queue element
                int[] point = queue.poll();
                for(int j = 0;j<4;j++) // 4 because there  are  4 direction to go in corordinate axix
                {
                    int x = point[0]+dx[j];
                    int y = point[1]+dy[j];
                    
                    // checking if x or y movement is not inside the grid or if the next 
                    //cell is empty, or has an already rotten orange, then we skip the current iteration
                    if(x<0 || y<0 || x>=rows || y>= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    
                    grid[x][y] = 2; // make it as rotten
                    queue.offer(new int[]{x,y}); // and add the new rotten orange to the queue
                }
            }
            // if  we still have rotten oranges
            if(queue.size() != 0) minutes++;
        }
        // if the original number of oranges and the oranges traversed by queue is same
        // it means all oranges have been rotten, else all oranges can't be rotten
        return oranges==count?minutes:-1;
    }
}