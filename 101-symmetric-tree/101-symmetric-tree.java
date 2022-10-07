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
    public boolean isSymmetric(TreeNode root) {
        // if root is null, return true
        return (root==null) || help(root.left,root.right);
    }
    
    public boolean help(TreeNode left, TreeNode right){
        // if left or right is null, return if they are  same or not
        if(left==null || right == null) return left==right;
        // check if left val is same as right val
        if(left.val!=right.val) return false;
        // check if left ka left and left ka right are same and 
        // left ka right and right ka left are same or not
        return help(left.left,right.right) && help(left.right, right.left);
    }
}