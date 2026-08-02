class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            int curr = Math.max(prev1, nums[i] + prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna