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

// perform an inorder Traversal 
// store in in a list
// check if list is sorted or not 
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         inorder(root,list);
//         for(int i = 1;i<list.size();i++){
//             if(list.get(i-1)>=list.get(i)) return false;
//         }
//         return true;
//     }
//     private void inorder(TreeNode root, List<Integer> list){
//         if(root == null) return;
//         inorder(root.left,list);
//         list.add(root.val);
//         inorder(root.right,list);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        // check for both left subtree  and right subtree if values are in the range
        return isValidBST(root.left,minVal,root.val) && isValidBST(root.right,root.val,maxVal);
    }
}