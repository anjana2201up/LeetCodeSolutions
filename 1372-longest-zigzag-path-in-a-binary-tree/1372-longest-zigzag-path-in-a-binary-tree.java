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

    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        dfs(root.left, true, 1);
        dfs(root.right, false, 1);

        return maxLength;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxLength = Math.max(maxLength, length);

        if (isLeft) {
            // Previous move was left
            dfs(node.right, false, length + 1); // Continue ZigZag
            dfs(node.left, true, 1);            // Restart
        } else {
            // Previous move was right
            dfs(node.left, true, length + 1);   // Continue ZigZag
            dfs(node.right, false, 1);          // Restart
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna