class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store right subtree
        TreeNode rightSubtree = root.right;

        // Move left subtree to right
        root.right = root.left;
        root.left = null;

        // Find end of moved subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Attach original right subtree
        current.right = rightSubtree;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna