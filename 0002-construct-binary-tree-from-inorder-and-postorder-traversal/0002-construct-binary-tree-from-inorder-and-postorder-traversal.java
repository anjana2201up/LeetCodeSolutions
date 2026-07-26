class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode build(int[] inorder,int[] postorder,int left,int right){
        if(left>right){
            return null;
        }
        int val=postorder[index--];
        TreeNode root=new TreeNode(val);
        int pos=map.get(val);

        root.right=build(inorder,postorder,pos+1,right);
        root.left=build(inorder,postorder,left,pos-1);

        return root;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna