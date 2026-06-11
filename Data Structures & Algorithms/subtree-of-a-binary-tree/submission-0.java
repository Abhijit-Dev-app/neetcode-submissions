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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(CheckingSubroot(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean CheckingSubroot(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        boolean check1 = CheckingSubroot(root.left, subRoot.left);
        boolean check2 = CheckingSubroot(root.right, subRoot.right);
        return check1 && check2;
    }

}
