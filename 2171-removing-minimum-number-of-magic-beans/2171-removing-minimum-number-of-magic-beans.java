// refer to coding decoded YT
class Solution {
    public long minimumRemoval(int[] beans) {
        long min = Long.MAX_VALUE, sum = 0;
        for(int i: beans) sum+=i;
        Arrays.sort(beans);
        int  len = beans.length;
        for(int i = 0; i<len; i++){
            long possible = sum-((len-i+0L)*beans[i]); // check possibility at every index
            min= Math.min(min,possible); // and store the minimum
        }
        return min;
    }
}