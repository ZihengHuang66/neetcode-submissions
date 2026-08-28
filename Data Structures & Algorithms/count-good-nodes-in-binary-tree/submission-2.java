class Solution {
    public int goodNodes(TreeNode root) {
        // 初始时，路径上的最大值就是根节点的值
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxVal) {
        if (root == null) {
            return 0;
        }

        int currentGood = 0;
        // 只要当前节点值大于或等于路径最大值，就是好节点
        if (root.val >= maxVal) {
            currentGood = 1;
            maxVal = root.val; // 更新路径最大值
        }

        // 必须同时遍历左子树和右子树，不能漏掉任何一边
        int leftGood = dfs(root.left, maxVal);
        int rightGood = dfs(root.right, maxVal);

        return currentGood + leftGood + rightGood;
    }
}
