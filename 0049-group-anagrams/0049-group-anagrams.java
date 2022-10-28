class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> grouped = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String current : strs){
            char[] arr = current.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr); // we have current word in sorted version
            // 2 anagrams after sorting will be the same string
            
            // if map dosen't contain the current element, we add it, with a new Arraylist
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            // we add that current  element to the list;
            map.get(sorted).add(current);
        }
        // add  all values of  the hashmap to the final list
        return new ArrayList<>(map.values());
    }
}