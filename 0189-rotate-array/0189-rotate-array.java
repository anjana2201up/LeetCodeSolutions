class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        k = k % n;   // handle k > n

        reverse(nums, 0, n - 1);      // Reverse whole array
        reverse(nums, 0, k - 1);      // Reverse first k elements
        reverse(nums, k, n - 1);      // Reverse remaining elements
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna