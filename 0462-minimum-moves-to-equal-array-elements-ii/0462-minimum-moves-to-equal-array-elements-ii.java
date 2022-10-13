// same logic as 2033. Minimum Operations to Make a Uni-Value Grid
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        // odd length array -> 1 Median
        if(len%2==1){
            int median = nums[len/2];
            for(int i : nums){
                ans+=Math.abs(i-median);
            }
        }else{
            int median1 = nums[(len/2)-1];
            int median2 = nums[(len/2)];
            int ans1 = 0, ans2 = 0;
            // for median1
            for(int i: nums){
                ans1+=Math.abs(i-median1);
            }
            // for median2
            for(int i:nums){
                ans2+=Math.abs(i-median2);
            }
            ans = Math.min(ans1,ans2);
        }
        return ans;
    }
}