/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TUF Free ka Tree series 
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>(); // map stores parent of nodes
        markParents(root,parent);
        Map<TreeNode, Boolean> visited = new HashMap<>(); // visited map
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k)break;
            curr_level++;
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.poll();
                // if left exists, go there if unvisited
                if(curr.left != null && visited.get(curr.left)==null){
                    queue.offer(curr.left);
                    visited.put(curr.left,true);
                }
                // if right exists, go there if unvisited
                if(curr.right != null && visited.get(curr.right) == null){
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                // if parent exists, visit if unvisited
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null){
                    queue.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }
        List<Integer> result  = new  ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
        }
        return  result;
    }
    //map -> child:parent
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            // if left exists
            if(curr.left  != null){
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            // if right exists
            if(curr.right != null){
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
}