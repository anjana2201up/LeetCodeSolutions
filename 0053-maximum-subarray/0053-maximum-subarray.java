class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm: maintain current subarray sum and global max.
        // Time Complexity: O(n) – each element processed once.
        // Space Complexity: O(1) – only constant extra variables used.
        // This solution correctly handles arrays with all negative numbers
        // because it initializes currentSum and maxSum with nums[0].
        // No further optimization needed; this is optimal for the problem.

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna