class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int i = 0, j = 0, min = Integer.MAX_VALUE,sum=0;
        
        while(j<nums.length){
            sum+=nums[j++];
            // substract from the begining
            while(sum>=target){
                min = Math.min(min,j-i);
                sum-=nums[i++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}