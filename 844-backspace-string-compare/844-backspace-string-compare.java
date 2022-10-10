class Solution {
    public boolean backspaceCompare(String s, String t) {
        return sb(s).equals(sb(t));
    }
    
    private String sb(String str){
        StringBuilder sbr = new StringBuilder();
        
        for(char c : str.toCharArray()){
            
            // if char is not hashtag, then appendit normally to the string builder string
            if(c!='#') sbr.append(c);
            
            // else delet one charachter before the hashtag 
            else if(sbr.length()!=0) sbr.deleteCharAt(sbr.length() -1 );
        }
        return sbr.toString();
    }
}