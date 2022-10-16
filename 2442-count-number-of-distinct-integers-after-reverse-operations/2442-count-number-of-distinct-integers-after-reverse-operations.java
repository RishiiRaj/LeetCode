class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set =  new HashSet<>();
        for(int i : nums) {
            set.add(i);
            set.add(rev(i));
        }
        return set.size();
    }
    private int rev(int n){
        String s = n+"";
        String rev = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(rev);
    }
}