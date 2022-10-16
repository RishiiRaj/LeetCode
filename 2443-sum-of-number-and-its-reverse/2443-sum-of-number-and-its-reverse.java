class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0) return true;
        for(int i = 1; i<=num; i++){
            if(i+rev(i) == num) return true;
        }
        return  false;
    }
    private int rev(int num){
        String s = num+"";
        String rev = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(rev);
    }
}