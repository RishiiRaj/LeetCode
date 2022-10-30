// brute force approach
// using one for loop to  iterate from the front
// using  another for loop to iterate from back
// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] ans = new int[2];
//         Arrays.fill(ans,-1);
//         if(nums==null || nums.length==0) return ans;
//         int l = nums.length;
//         for(int i =0;i<l;i++){
//             if(nums[i]== target) ans[1]=i;
//         }
//         for(int i = l-1;i>=0;i--){
//             if(nums[i]== target) ans[0]=i;
//         }
//         return ans;
//     }
// }

// using binary search for optimal solution
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums==null || nums.length==0) return ans;
        ans[0] = findStartidx(nums,target);
        ans[1] = findEndidx(nums,target);
        return ans;
    }
    
    public int findStartidx(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int idx=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)idx=mid;
            // here target>nums[mid]
            if(target>nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return idx;
    }
    
    public int findEndidx(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int idx=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)idx=mid;
            // only difference is here  target>=nums[mid]
            if(target>=nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return idx;
    }
}