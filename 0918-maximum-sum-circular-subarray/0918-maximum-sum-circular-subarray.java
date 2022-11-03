class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int nonCircularSum = kadaneMaxSum(A);
        int totalSum = 0;
        // finding  total sum of array
        // and reversing each element to get minimum subarray sum using the same function
        for(int i=0;i<A.length;i++){
            totalSum += A[i];
            A[i] = -A[i];
        }
        // substracting minimum subarray sum from total sum gives maximum circular subarray sum. 
        int circularSum = totalSum + kadaneMaxSum(A);
        if(circularSum == 0)
            return nonCircularSum;
        return Math.max(circularSum,nonCircularSum);
    }
    
    int kadaneMaxSum(int[] A){
        int currentSum = A[0];
        int maxSum = A[0];
        for(int i=1;i<A.length;i++){
            if(currentSum < 0)
                currentSum = 0;
            currentSum = A[i] + currentSum;
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}