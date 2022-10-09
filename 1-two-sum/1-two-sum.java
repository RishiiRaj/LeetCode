// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int ans[] = new  int [2];
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]+nums[j] == target){
//                     ans[0]=i;
//                     ans[1]=j;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution{
     public int[] twoSum(int[] nums, int target) {
         int[] ans = new int[2]; // make an array of size 2 to store the answer
         // create a HashMap for calculation
         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
         int l = nums.length;
         // iterate through the array
         for(int i = 0; i<l;i++){
             // if target-current arraay element is present in the hashmap, then those 2 are the ans
             if(map.containsKey(target-nums[i])){
                 ans[0]=i;
                 ans[1]=map.get(target-nums[i]);
             }
             // if not, we put the current array value in the hashmap
             map.put(nums[i],i);
         }
         return ans;
     }
}