// refer to algorithms made easy YT
class Solution {
    public List<String> letterCasePermutation(String s) {
        // we need to return a list, and use a queue for computation, so we use a linkedlist
        LinkedList<String> l = new LinkedList<>();
        l.add(s);
        int n= s.length();
        
        for(int i = n-1; i>=0; i--){
            char c = s.charAt(i);
            // find permuations only if character is a letter
            if(Character.isLetter(c)){
                int size = l.size();
                while(size-- >0){
                    String curr = l.poll(); // curr element in queue
                    String left = curr.substring(0,i); // left subpart
                    String right = curr.substring(i+1); // right subpart
                
                    l.add(left+Character.toLowerCase(c)+right);
                    l.add(left+Character.toUpperCase(c)+right);
                }
            }
        }
        return l;
    }
}