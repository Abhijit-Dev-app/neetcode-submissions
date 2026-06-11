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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>lst = new ArrayList<>();
        kthSmall(root, lst);
        int ans = 0;
        for(int i = 0;i<lst.size(); i++){
            if(i == k-1)
                ans = lst.get(i);
        }
        return ans;
    }
    public void kthSmall(TreeNode root, List<Integer>lst){
        if(root == null){
            return;
        }

        kthSmall(root.left, lst);
        lst.add(root.val);
        kthSmall(root.right, lst);
    }
}
