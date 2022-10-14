class Solution {
    public int lastRemaining(int n) {
        boolean l2r = true; // means left 2 right
        int step = 1, start = 1; // initial start is 1
        
        while(n>1){
            if(l2r){
                start+=step;
            }else{
                start+=(n%2==1)?step:0;
            }
            step*=2; // double steps after every move
            n/=2;
            l2r=!l2r; // change direction after every move
        }
        return  start;
    }
}