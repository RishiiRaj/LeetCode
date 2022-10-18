/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // use array of size 1 
        // variabe will not work because of pass by value  wala  locha
        int[] depth = new int[1];
        int[] sum = new  int[1];
        return  dfs(root,sum,0,depth);
    }
    public int dfs(TreeNode root, int[] sum, int depth, int[] deepest){
        if(root == null) return 0;
        // if node is a leaf
        if(root.left == null && root.right == null){
            if(depth == deepest[0]) sum[0]+=root.val; // at maximum depth
            // found deeper
            else if(depth > deepest[0]){
                sum[0]=root.val; // reset sum
                deepest[0] = depth; // update deepeset depth
            }
        }
        dfs(root.left,sum,depth+1,deepest);
        dfs(root.right,sum,depth+1,deepest);
        
        return sum[0];
    }
}