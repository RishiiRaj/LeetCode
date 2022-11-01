class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // stradegy is to first fix an element, and check if any 2 numbers add up to the negative of
        // that fixed number using 2 sum stradegy
        
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        
        for(int i = 0; i<nums.length-2;i++){
            // we can also use the reverse of the 2nd condition and continue statement
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low = i+1, high = nums.length - 1;
                int sum = 0-nums[i]; // we could put k instead of 0 if sum required was equal to k
                
                while(low<high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        // removing adjecent duplicates
                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        
                        // move both pointers one step each
                        low++;
                        high--;
                    }else if(nums[low]+nums[high] > sum)
                        high--;
                    else low++;
                }
            }
        } return res;
    }
}