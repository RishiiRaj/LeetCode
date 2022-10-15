class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // live to dead = -1
        // dead to alive = 2;
        
        // we give initial state so it dosen't affect other neighbours
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                // dies due  to under population
                if(board[i][j] == 1 && padosi(i,j,board) < 2)
                    board[i][j] = -1;
                // dies due to over population
                if(board[i][j] == 1 && padosi(i,j,board) > 3)
                    board[i][j] = -1;
                // re-incarnated due to population
                if(board[i][j] == 0 && padosi(i,j,board) == 3)
                    board[i][j] = 2;
            }
        }
        
        // changing -1 to 0 and 2 to 1
        for(int  i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    public int padosi(int i, int j, int[][] board){
        int count = 0;
        int b = board.length;
        int c = board[0].length;
        
        // checking for live padosi
        // also check  for -1 becaise if -1 dies, it is chenged to -1 before changing to 0
        
        // checking for top left neighbour
        if(i-1>=0 && i-1 < b && j-1>=0 && j-1<c){
            if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1)
                count++;
        }
        // checking for left neighbour
        if(i-1>=0 && i-1 < b && j>=0 && j<c){
            if(board[i-1][j] == 1 || board[i-1][j] == -1)
                count++;
        }
        // checking for bottom left neighbour
        if(i-1>=0 && i-1 < b && j+1>=0 && j+1<c){
            if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1)
                count++;
        }
        // checking for top neighbour
        if(i>=0 && i < b && j-1>=0 && j-1<c){
            if(board[i][j-1] == 1 || board[i][j-1] == -1)
                count++;
        }
        // checking for bottom neighbour
        if(i>=0 && i < b && j+1>=0 && j+1<c){
            if(board[i][j+1] == 1 || board[i][j+1] == -1)
                count++;
        }
        // checking for top right neighbour
        if(i+1>=0 && i+1 < b && j-1>=0 && j-1<c){
            if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1)
                count++;
        }
        // checking for right neighbour
        if(i+1>=0 && i+1 < b && j>=0 && j<c){
            if(board[i+1][j] == 1 || board[i+1][j] == -1)
                count++;
        }
        // checking for bottom right neighbour
        if(i+1>=0 && i+1 < b && j+1>=0 && j+1<c){
            if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1)
                count++;
        }
        return count;
    }
}