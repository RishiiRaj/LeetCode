class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> map = new TreeSet<>();
        for(int i : nums){
            map.add(i);
        }
        for(int i : map){
            if(map.contains(-i)) return -i;
        }
        return -1;
    }
}