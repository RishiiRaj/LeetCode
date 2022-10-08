class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length -1];
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            
            while(left < right){
                int curr_sum = nums[i] + nums[left] + nums[right];
                
                if(curr_sum > target){
                    right--;
                }else{
                    left++;
                }
                
                if(Math.abs(curr_sum-target)<Math.abs(result-target)){
                    result = curr_sum;
                }
            }
        }
        return result;
    }
}