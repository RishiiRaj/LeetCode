class MyQueue {

    // make 2  stacks, input and output
    
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();
        
        
    public MyQueue() {
        
    }
    
    // push normally to input stack
    public void push(int x) {
        input.push(x);
    }
    
    // if output not empty then output.pop
    // else transfer all input stack elements to output and then putput.pop
    public int pop() {
        if(!output.isEmpty()){
            return output.pop();
        }
        else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return output.pop();
        }
    }
    
    // if output not empty, return output top
    // else transfer all input elements to output, then output.top 
    public int peek() {
        if(!output.isEmpty()){
            return output.peek();
        }
        else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return output.peek();
        }
    }
    
    // normally check if both are empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */