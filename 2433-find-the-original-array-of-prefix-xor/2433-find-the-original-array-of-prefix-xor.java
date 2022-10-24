// reverse operation of + is -
// reverse operation of ^ is still ^
class Solution {
    public int[] findArray(int[] pref) {
        // try to get the  orginal array from the back
        for(int i = pref.length-1; i>0; i--){
            pref[i]^=pref[i-1];
        }
        return pref;
    }
}