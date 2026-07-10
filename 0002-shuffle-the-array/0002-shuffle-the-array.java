class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[2 * n];

        int i = 0;
        int j = n;
        int k = 0;

        while (i < n) {
            ans[k++] = nums[i++];
            ans[k++] = nums[j++];
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna