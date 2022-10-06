// refer to naresh gupta YT
class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s,new HashSet<>());
    }
    private int backtrack(String s, Set<String> seen){
        int maxi = 0;
        for(int i = 1; i<=s.length(); i++){
            String temp = s.substring(0,i);
            // if string is not contained in the set already
            if(!seen.contains(temp)){
                seen.add(temp); // add it
                int bt = 1+backtrack(s.substring(i),seen);// try possibilities
                maxi = Math.max(maxi,bt); //store maxi
                seen.remove(temp); // remove last and backtrack
            }
        }
        return maxi; // return maxi
    }
}