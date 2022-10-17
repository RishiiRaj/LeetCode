// refer to Algorithms made easy YT
class Solution {
    String[] combos = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        // base case
        if(digits.length() == 0) return ans;
        backtrack(0,digits,new StringBuilder(), ans);
        return ans;
    }
    private void backtrack(int length, String digits, StringBuilder sb, List<String> ans){
        // base condition
        if(length == digits.length()){
            ans.add(sb.toString());
            return;
        }
        // loop on digit present at 'length' index
        char ch = digits.charAt(length);
        String temp = combos[ch-'0'];
        // backtrack
        for(char c : temp.toCharArray()){
            sb.append(c);
            backtrack(length+1, digits, sb, ans);
            sb.deleteCharAt(sb.length()-1); // remove last char
        }
    }
}