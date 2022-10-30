// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         // since rows are sorted
//         int i = 0, j = matrix[0].length-1,n=matrix.length;
//         // we start by placing the pointer to the last index of the first row
//         // everything at the  left of  this index will be lesser than that value
//         // everything below that index in that column, will be greater than that index value
//         while(i<n && j>=0){
//             if(matrix[i][j] == target){
//                 return true;
//             }
//             // if target is less than that the index value, we  move  one  coloumn left
//             if(matrix[i][j] > target){
//                 j--;
//             }
//             // if target is greater than the  index value, then  we  are  sure that it is in that
//             // column only, then  we need to increment the row
//             else{
//                 i++;
//             }
//         }
//         // if target is not in the matrix, poiner will keep changing and eventually
//         // get out of the while loop.
//         return false;
//     }
// }

// binary search in 2D array (optimal solution)
class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0) return  false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low = 0,high = (m*n)-1;
        
        // just simple binary search;
        while(low<=high){
            int mid = low + (high-low)/2;
            // finding value of row and column by 
            // row value = mid  value / column length
            // column value = mid value % column length
            int mid_row = mid/m;
            int mid_col = mid%m;
            
            if(matrix[mid_row][mid_col] == target) return true;
            
            if(matrix[mid_row][mid_col]<target) low = mid+1;
            
            else high = mid-1;
        }
        return false;
    }
}