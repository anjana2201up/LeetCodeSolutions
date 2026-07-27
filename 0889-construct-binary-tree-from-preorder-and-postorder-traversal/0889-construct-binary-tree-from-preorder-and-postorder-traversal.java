class Solution {
    int preIndex=0,postIndex=0;

    public TreeNode constructFromPrePost(int[] preorder,int[] postorder) {
        TreeNode root=new TreeNode(preorder[preIndex++]);
        if(root.val!=postorder[postIndex])
            root.left=constructFromPrePost(preorder,postorder);
        if(root.val!=postorder[postIndex])
            root.right=constructFromPrePost(preorder,postorder);
        postIndex++;
        return root;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna