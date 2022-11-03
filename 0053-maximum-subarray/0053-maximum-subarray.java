class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        // we run a for each loop
        for(int i:nums){
            sum+=i; // store the current sum of the array
            if(sum>max) max = sum; // store the max sum of the array
            if(sum<0) sum = 0; // if sum goes below zero, make sum as 0
        }
        return max;
    }
}