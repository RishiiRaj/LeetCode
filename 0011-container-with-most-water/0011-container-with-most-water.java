class Solution {
    
    // brute force solution to find area between all pairs of heights
    // and find the maximum area
    // public int maxArea(int[] height) {
    //     int l = height.length;
    //     int max = 0;
    //     for(int i = 0;i<l-1;i++){
    //         for(int j = i+1;j<l;j++){
    //             int area = (j-i) * Math.min(height[j],height[i]);
    //             max = Math.max(max, area);
    //         }
    //     }
    //     return max;
    // }
    
    // optimal approach
    public int maxArea(int[] height) {
        int l = height.length;
        int low = 0, high = l-1;
        // find area with default low and high to jump the edge case
        int max = (high-low) * Math.min(height[low],height[high]);
        
        while(low<high){
            // move the pointer with the small height
            if(height[low]<=height[high]) low++;
            else high--;
            
            // find area and store the max area found till now
            int area = (high-low) * Math.min(height[low],height[high]);
            max = Math.max(max,area);
        }
        return max;
    }
}