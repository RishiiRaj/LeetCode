class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0; i<nums.length; i++){
            int GCD = nums[i];
            for(int  j = i; j<nums.length; j++){
                GCD = gcd(GCD, nums[j]);
                if(GCD == k) cnt++;
            }
        }
        return cnt;
    }
    private  int gcd(int a, int b){
        if(b==0) return  a;
        return gcd(b,a%b);
    }
}