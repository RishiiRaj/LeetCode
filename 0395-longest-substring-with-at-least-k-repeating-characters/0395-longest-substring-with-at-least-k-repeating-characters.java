class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() == 0 || k > s.length()) return 0;
        if(k==0) return s.length();
        
        // map  thr frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            char c =s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int index = 0;
        // go until index is within the string and freq  of each  char is >= k
        while(index < s.length() && map.get(s.charAt(index)) >= k){
            index++;
        }
        if(index == s.length()) return s.length();
        // find max of both left part and right part using divide and conquer
        int left = longestSubstring(s.substring(0,index),k);
        int right = longestSubstring(s.substring(index+1), k);
        
        return Math.max(left,right);
    }
}