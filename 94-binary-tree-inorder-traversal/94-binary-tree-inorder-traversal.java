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
// class Solution {
    
//     // declare the list outside the  function, else it won't work
//     List<Integer> list = new ArrayList<>();

//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null) return list;
        
//         inorderTraversal(root.left);
//         list.add(root.val);
//         inorderTraversal(root.right);
        
//         return list;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root; // a node to traverse
        
        // go to left node first
        while(true){
            // if node is not null, we push it to the stack and move to the left
            if(node != null){
                s.push(node);
                node = node.left;
            }else{ // when it is null
                if(s.isEmpty()){
                    // break when the stack goes empty
                    break;
                }
                // or add the top element of the stack and move to the right
                node = s.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}