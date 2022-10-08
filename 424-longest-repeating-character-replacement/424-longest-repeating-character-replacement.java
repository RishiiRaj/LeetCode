class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0; // start of window
        int max = 0; // to store resultant
        int max_count = 0; // to store length of current max repeating element
        int n = s.length();
        
        int char_count[] = new int[26]; // size is 26 coz 26 letters in english
        
        for(int end = 0 ; end < n ; end++){ // end of window
            
            char_count[s.charAt(end) - 'A']++; // increment the count
            
            int current_char_count = char_count[s.charAt(end) - 'A']; // store that in a variable
            max_count = Math.max(max_count , current_char_count); // find max
            
            // decrease the window size
            while(end - start + 1 - max_count > k){ 
                char_count[s.charAt(start) - 'A']--;
                start++;
            }
            max = Math.max(max , end-start+1);
        }
        return max;
    }
}