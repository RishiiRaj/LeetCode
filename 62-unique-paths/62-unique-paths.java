// basic approach is to use reccursion, and it uses exponential time and space
// better approach is to use dynamic programming approach
// most optimal approach is to use combination
// on observing, we notice that no. or right moves is one less than the number of rows
// and  number of down moves is one  less than the number of columns
// total directions to choose is (m-1)+(n-1) = m+n-2
// answer  will be (m+n-2)C(n-1) or (m+n-2)C(m-1) both  will give  the same  answer
// shortcut to find  out nCr is, find r! and number of multiplications in denominator 
// that will be equal to number of multiplications is n! from the starting
// example 10C3 = (10x9x8)/(3x2x1)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        // answer will be (m+n-2)C(n-1) or (m+n-2)C(m-1)
        int nc=m+n-2;
        int r=m-1;
        double res=1; // taaking integer here will give wrong answer, idk why
        for(int  i = 1;i<=r;i++){
            // here  i will be denominator
            // and  nc-r+i will be numerator
            res=res* (nc-r+i)/i;
        }
        return (int)res;
    }
}