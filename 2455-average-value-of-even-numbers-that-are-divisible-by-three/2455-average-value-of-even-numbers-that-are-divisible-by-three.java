class Solution {
    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for(int i : nums){
            if(i%2 == 0 && i%3 == 0){
                count++;
                sum+=i;
            }
        }
        return count==0?0:sum/count;
    }
}