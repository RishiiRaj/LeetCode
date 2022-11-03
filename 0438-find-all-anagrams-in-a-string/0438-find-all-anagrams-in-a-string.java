class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        
        int s_len = s.length(), p_len = p.length();
        // base case
        if(p_len > s_len) return l;
        
        int[] Count = freq(p); // frequency of string p
        int[] curr_count = freq(s.substring(0,p_len)); // freq of string  s until length of p
        
        if(isSame(Count,curr_count)) l.add(0);// check if they are same, then add
        
        for(int i = p_len; i<s_len;i++){
            curr_count[s.charAt(i-p_len) - 'a']--; // remove 1st char freq of window 
            curr_count[s.charAt(i)-'a']++; // add  new char freq
            if(isSame(Count,curr_count)){
                l.add(i-p_len+1);
            }
        }
        return l;
    }
    // return  frequency array for a string
    private int[] freq(String s){
        int[] f = new int[26];
        for(int i =0; i<s.length();i++){
            f[s.charAt(i)-'a']++;
        }
        return f;
    }
    // check if2 arrays  are saame or not
    private boolean isSame(int[] x, int[] y){
        for(int i = 0; i<26; i++){
            if(x[i]!=y[i]) return false;
        }
        return true;
    }
}