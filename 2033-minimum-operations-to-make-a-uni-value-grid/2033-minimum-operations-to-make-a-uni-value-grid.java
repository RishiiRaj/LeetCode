// refer to  aditya rajiv YT
class Solution {
    public int minOperations(int[][] grid, int x) {
        if(!isPossible(grid,x)) return -1;
        // copy the grid into a list
        List<Integer> list = new  ArrayList<>();
        for(int i = 0;  i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list); // sort it
        int len = list.size(), ans = 0;
        // odd  length  of list -> 1 median
        if(len%2==1){
            int median = list.get(len/2);
            for(int i = 0; i<len;i++){
                ans+=Math.abs(list.get(i)-median)/x;
            }
        }
        // even length of list -> 2 medians
        else{
            int median1 = list.get((len/2)-1);
            int median2 = list.get((len/2));
            int ans1 = 0, ans2 = 0;
            // find ans for both medians, and return the min
            for(int i = 0; i<len;i++){
                ans1+=Math.abs(list.get(i)-median1)/x;
            }
            for(int i = 0; i<len;i++){
                ans2+=Math.abs(list.get(i)-median2)/x;
            }
            ans = Math.min(ans1,ans2);
        }
        return ans;
    }
    // function to checkk if answer is possible or not
    // if mod of all the elements with x is not same, then false, else true 
    private boolean isPossible(int[][] grid, int x){
        int mod = grid[0][0]%x;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]%x != mod) return false;
            }
        }
        return true;
    }
}