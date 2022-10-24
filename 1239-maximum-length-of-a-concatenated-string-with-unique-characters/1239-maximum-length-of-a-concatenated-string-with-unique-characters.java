class Solution {
    public int maxLength(List<String> arr) {
        // used array to avoid global variables
        int[] maxi = new int[1];
        dfs(0,"",arr,maxi);
        return maxi[0];
    }
    
    private void dfs(int index, String s, List<String> arr, int[] maxi){
        // if current string is not unique, just return
        if(!isUnique(s)){
            return;
        }    
        // find maximum
        maxi[0] = Math.max(maxi[0],s.length());
        // try other combinations
        for(int i = index; i<arr.size();i++){
            String str = arr.get(i);
            dfs(i+1,s+str,arr, maxi);
        }
    }
    // check if  a string is of all unique chars or not
    private boolean isUnique(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i : freq) if(i > 1) return false;
        return true;
    }
}