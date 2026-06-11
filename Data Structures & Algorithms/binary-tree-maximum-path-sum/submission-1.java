// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// public class Solution {
//     int res = Integer.MIN_VALUE;

//     public int maxPathSum(TreeNode root) {
//         dfs(root);
//         return res;
//     }

//     private int getMax(TreeNode root) {
//         if (root == null) return 0;
//         int left = getMax(root.left);
//         int right = getMax(root.right);
//         int path = root.val + Math.max(left, right);
//         return Math.max(0, path);
//     }

//     private void dfs(TreeNode root) {
//         if (root == null) return;
//         int left = getMax(root.left);
//         int right = getMax(root.right);
//         res = Math.max(res, root.val + left + right);
//         dfs(root.left);
//         dfs(root.right);
//     }
// }
public class Solution{
    public int maxPathSum(TreeNode root){
        int[]res = new int[]{root.val};
        dfs(root, res);
        return res[0];
    }
    public int  dfs(TreeNode root, int[]res){
        if(root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left, res), 0);
        int right = Math.max(dfs(root.right, res), 0);
        res[0] = Math.max(res[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}