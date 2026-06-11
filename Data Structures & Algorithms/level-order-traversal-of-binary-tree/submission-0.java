class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
                TreeNode rem = queue.poll(); 
                list.add(rem.val);

                if (rem.left != null) queue.offer(rem.left);
                if (rem.right != null) queue.offer(rem.right);
            }

            result.add(list);
        }

        return result;
    }
}
