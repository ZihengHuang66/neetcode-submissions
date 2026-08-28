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
    public int diameterOfBinaryTree(TreeNode root) {
        // Use a 1-element array to act as a pass-by-reference integer tracker
        int[] maxDiameter = new int[1]; 
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }
    
    private int dfs(TreeNode node, int[] maxDiameter) {
        // Base case: null nodes contribute 0 to the height
        if (node == null) {
            return 0;
        }
        
        // Post-order traversal: collect heights from children first
        int leftHeight = dfs(node.left, maxDiameter);
        int rightHeight = dfs(node.right, maxDiameter);
        
        // Calculate the path (edges) passing through the current node
        int currentDiameter = leftHeight + rightHeight;
        
        // Update the global maximum if this path is larger
        maxDiameter[0] = Math.max(maxDiameter[0], currentDiameter);
        
        // Return the height of this subtree to the parent node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

