class Solution {
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            // if at any place, ith position is more than the maximum posi that can be reached, return  false
            if(i>max) {return false;}
            // storing the maximum place that can be reached
            max = Math.max(A[i]+i,max);
        }
        return true;
    }
}