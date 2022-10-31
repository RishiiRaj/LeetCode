class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        int l = 0, r = n-1;
        while(l<r){
            int mid = (l+r)/2;
            if(mid>0 && nums[mid] < nums[mid-1]) 
                return nums[mid];
            
            if(nums[l]<=nums[mid] && nums[mid] > nums[r]){ // right half is unsorted, min lies here
                l=mid+1;
            }else{ // left half is unsorted, mis is here
                r=mid-1;
            }
        }
        return nums[l];
    }
}