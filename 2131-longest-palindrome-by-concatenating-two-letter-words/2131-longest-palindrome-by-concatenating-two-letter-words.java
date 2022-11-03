class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> hm=new HashMap<>();
        int count=0;
        // put all words in a hashmap and count their frequencies
        for(String s : words){
            hm.put(s,hm.getOrDefault(s,0)+1); 
        }
        for(Map.Entry m: hm.entrySet()){
            String key=(String)m.getKey();
            int val=(int)m.getValue();
            String rev=reverse(key);
            // if pair exists
            if(hm.containsKey(rev)){
                // if  string is a palindrome itself
                if(rev.equals(key)){
                    // get maximum evel  length
                    int y=hm.get(rev);
                    if(y%2!=0)
                        y--;
                    count+=(2*y);
                    hm.replace(rev,hm.get(rev)-y); // decrease  the count by the maximum taken length
                }
                else{
                    // take  minimum of both  frequencies
                    int min=Math.min(val,hm.get(rev));
                    count+=(4*min);
                    // replcace both their frequencies
                    hm.replace(key,val-min);
                    hm.replace(rev,hm.get(rev)-min);
                }
            }
        }
        // check for words with samefirstand 2nd char which can be put in the middle
        for(Map.Entry m: hm.entrySet()){
            String key=(String)m.getKey();
            int val=(int)m.getValue();
            if(key.charAt(0)==key.charAt(1) && val>0){
                count+=2;
                break;
            }
        }
        return count;
    }
    static String reverse(String s){
        String ans="";
        for(int i=1;i>=0;i--)
            ans+=s.charAt(i);
        
        return ans;
    }
}