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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        Solve(root, root.val);
        return count;
    }
    public void Solve(TreeNode root, int maxSofar){
        if(root == null){
            return;
        }
        if(root.val >= maxSofar){
            count++;
        }
        maxSofar = Math.max(maxSofar, root.val);
        Solve(root.left, maxSofar);
        Solve(root.right, maxSofar);
        return;
    }
}
