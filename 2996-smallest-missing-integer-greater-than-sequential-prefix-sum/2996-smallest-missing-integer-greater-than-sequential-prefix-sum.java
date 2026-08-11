class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        int ans = sum;

        while (true) {
            boolean found = false;

            for (int num : nums) {
                if (num == ans) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return ans;
            }

            ans++;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna