class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map =  new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int cnt = 0;
        for(int  i : map.values()){
            if(i>1){
                cnt+=i*(i-1)/2;
            }
        }
        return cnt;
    }
}