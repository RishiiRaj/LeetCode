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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        
        if(root == null) return ans;
        // first insert the root in the queue
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize = q.size();// stores current queue size
            List<Integer> list = new LinkedList<>();
            for(int i = 0;i<levelsize;i++){ // iterate for the current queue size
                // if left is not null of current queue lement, we add it to the queue
                if(q.peek().left != null) q.offer(q.peek().left);
                // similarly for right
                if(q.peek().right != null) q.offer(q.peek().right);
                
                // add the current queue value to the list
                list.add(q.poll().val);
            }
            // add the ist to the resultant list
            ans.add(list);
        }
        return ans;
    }
}