class Solution {
    public int primePalindrome(int N) {
        if (N == 1 || N == 2) return 2;
        if (N % 2 == 0) N++;
        while (true) {
            if (isPal(N) && isPrime(N)) return N;
            N += 2;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_001;
        }
    }
    private boolean isPrime(int n){
        if(n == 1) return false;
        for(int  i = 2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    private boolean isPal(int n){
        String s = n+"";
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
}