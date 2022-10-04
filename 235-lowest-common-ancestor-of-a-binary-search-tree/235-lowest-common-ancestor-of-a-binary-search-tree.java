/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive solution
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null) return root;
//         int curr = root.val;
//         // if both p and q lie on the right of the root
//         if(p.val > curr && q.val > curr){
//             return lowestCommonAncestor(root.right,p,q);
//         }
//         // if both p and q lie on the left of the root
//         if(p.val < curr && q.val < curr){
//             return lowestCommonAncestor(root.left,p,q);
//         }
//         return root;
//     }
// }

// iterative solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else break;
        }
        return root;
    }
}