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
// refer to algorithms made easy YT
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // insert at root level
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insert(root,depth,val,1);
        return root;
    }
    private void insert(TreeNode node, int depth, int val, int currDepth){
        // base case
        if(node == null) return;
        
        // reached point of  insertion
        if(currDepth == depth-1){
            // for left
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            // for right
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }else{
            insert(node.left, depth, val, currDepth+1);
            insert(node.right, depth, val, currDepth+1);
        }
    }
}