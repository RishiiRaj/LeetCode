// binary search can work only in sorted array, so we check if left  part is  sorted, else the righ part

class Solution {
    public int search(int[] nums, int target) {
        int low=0,high = nums.length - 1;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(target == nums[mid])
                return mid;
            //checking  if left half  is sorted
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }
                else
                    low=mid+1;
            // checking if right half is sorted
            }
            else{
                if(target>=nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
}