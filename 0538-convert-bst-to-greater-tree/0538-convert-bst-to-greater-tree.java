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
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    int sum = 0;
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right); // find the biggest element in bst
        root.val+=sum; // add sum to its value
        sum=root.val; // update  sum
        dfs(root.left); // move left
    }
}