// Brute force approach O(n)

// class Solution {
//     public int findPeakElement(int[] nums) {
//         for(int i=1;i<nums.length-1;i++){
//             if((nums[i]>nums[i-1]) && (nums[i]>nums[i+1]))
//                 return i;
//         }
//         return 0;
//     }
    
// }


// divide and conqueror technique, basically using binary search technique O(log n)
// aditya verma YouTube

// class Solution {
//     public int findPeakElement(int[] nums){
//         if(nums.length == 1) return 0;
//         int low = 0, high = nums.length - 1;
//         while(low<=high){
//             int mid = low + (high-low)/2;
//             if(mid>0 && mid<nums.length-1){ // checking in array except extreme elements
//                 // if middle  element satisfies condition
//                 if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
//                 // if right element > mid element, discarding left half
//                 else if(nums[mid+1]>nums[mid]) low = mid+1;
//                 // else discording  right side
//                 else if(nums[mid-1]>nums[mid]) high = mid-1;
//             }
//             // checking for extreme elements
//             else if(mid==0)
//                 if(nums[0]>nums[1]) return 0;    
//             else if(mid==nums.length-1)
//                 if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
//         }return 0;
//     }
// }

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            boolean leftIsIncreasing = mid > 0 && nums[mid] < nums[mid - 1]; 
            boolean rightIsIncreasing = mid < nums.length - 1 && nums[mid] < nums[mid + 1]; 
            if (!leftIsIncreasing && !rightIsIncreasing) {
                return mid;
            } else if (leftIsIncreasing) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}