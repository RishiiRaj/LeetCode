// brute force approach is to use nested loops, and check for every pair
// if the pair satisfies the condition, we increase counter by one.
// but... hah! this is leetcode hard, and will give TLE
/*
class Solution {
    public int reversePairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i+1; j < arr.length; j++)
                if ((long)arr[i] > (long)2 * arr[j])    // 21,47,483,647, which is max value of int, was                                                         given in some test cases
                    count++;
        return count;
    }
}
*/

// refer to TUF and just use Arrays.sort instead  of writing  the whole merge method
public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int start, int end){
        if(start >= end) return 0; 
        int mid = start + (end-start)/2; 
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end); 
        for(int i = start, j = mid+1; i<=mid; i++){
            while(j<=end && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1);  // count  enntire left half
        }
        Arrays.sort(nums, start, end+1); 
        return cnt; 
    }
}