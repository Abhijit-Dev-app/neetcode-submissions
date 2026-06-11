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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return  null;
        }
        TreeNode rootHead = root;
        Inverting(root);
        return rootHead;
    }
    public void Inverting(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;
        if(root.left != null && root.right != null){
            TreeNode Left = root.left;
            TreeNode Right = root.right;
            root.left = Right;
            root.right = Left;
        }
        else if(root.left == null && root.right != null){
            // TreeNode Left = root.left;
            TreeNode Right = root.right;
            root.left = Right;
            root.right = null;
        }
        else if(root.left != null && root.right == null){
            TreeNode Left = root.left;
            // TreeNode Right = root.right;
            root.left = null;
            root.right = Left;
        }
        Inverting(root1);
        Inverting(root2);
    }
}
