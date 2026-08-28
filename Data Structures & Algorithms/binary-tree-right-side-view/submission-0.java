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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = lot(root);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            List<Integer> curr = list.get(i);
            result.add(curr.get(curr.size() - 1));
        }
        return result;
    }

    private List<List<Integer>> lot(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int currLevel = 0;

        while(!q.isEmpty()) {
            int len = q.size();
            result.add(new ArrayList<>()); //!!!

            for(int i = 0; i < len; i++) {
                TreeNode node = q.remove(); //!!!
                result.get(currLevel).add(node.val);
                
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            currLevel++;
        }
        return result;
    }
}
