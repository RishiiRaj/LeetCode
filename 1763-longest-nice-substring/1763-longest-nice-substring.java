class Solution {
    public String longestNiceSubstring(String s) {
        int len = s.length();
        if (len < 2) return "";
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) set.add(c);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            // divide the string and find out answers  for both the halves
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            // return the max
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s; 
    }
}