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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
    // new function just for clarity
    public TreeNode merge(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        TreeNode new_tree = new TreeNode();
        new_tree.val = t1.val + t2.val;
        
        // recursively call for left and right subtree and assign left and right subtree
        new_tree.left = merge(t1.left,t2.left);
        new_tree.right = merge(t1.right,t2.right);
        
        return new_tree;
    }
}