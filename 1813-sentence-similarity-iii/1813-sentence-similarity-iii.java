class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if (sentence1.length () < sentence2.length ()) {
            return areSentencesSimilar (sentence2, sentence1);
        }
        
        String[] words1 = sentence1.split ("\\s");
        String[] words2 = sentence2.split ("\\s");
        
        int i = 0, j = words1.length - 1, k = words2.length - 1;
        
        // compare  from front
        while (i < words2.length && words1[i].equals (words2[i])) {
            i++;
        }
        
        // compare from back
        while (k >= 0 && words1[j].equals (words2[k])) {
            j--;
            k--;
        }
        // if pointers cross, it means that only one part has dis-similarity
        return i > k;
    }
}