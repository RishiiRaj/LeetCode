class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for(String querry : queries){
            for(String dict : dictionary){
                if(charDiff(querry,dict) <= 2){
                    res.add(querry);
                    break; // break out once done for that word
                }
            }
        }
        return res;
    }
    private int charDiff(String a, String b){
        // all words have same length
        int count = 0;
        for(int i = 0; i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}