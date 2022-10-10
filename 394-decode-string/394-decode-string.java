class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            // push everything until we fing a closing bracket
            if(c!=']'){
                stack.push(c);
            }
            // when we find the closing bracket
            else{
                // retrieve everything enclosed  in the  bracket
                StringBuilder sb = new  StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                String sub = sb.toString();
                stack.pop(); // getting rid of that '['
                
                // now get the number before the '['
                sb = new  StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                int count = Integer.valueOf(sb.toString()); // changing to integer
                
                // repeat the string in [] and push it  in the stack
                while(count > 0){
                    for(char ch : sub.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        
        // converting the stack to  string
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        
        
        return res.toString();
    }
}