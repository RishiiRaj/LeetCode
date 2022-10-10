class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        // if length  is 1, return empty string
        if(len <= 1) return "";
        
        StringBuilder sb = new StringBuilder(palindrome);
        // find  first non-'a' char and change it to 'a'
        for(int i = 0; i<len/2; i++){ // just go til half the length 
            if(palindrome.charAt(i) != 'a'){
                sb.setCharAt(i,'a');
                return sb.toString();
            }
        }
        // if string is of all 'a's then change the  last char to 'b'
        sb.setCharAt(len-1,'b');
        return sb.toString();
    }
}