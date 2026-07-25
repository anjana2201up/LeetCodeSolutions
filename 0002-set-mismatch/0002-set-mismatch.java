class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        int duplicate = 0;
        int missing = 0;

        for(int num : nums) {
            count[num]++;
        }

        for(int i = 1; i <= nums.length; i++) {
            if(count[i] == 2)
                duplicate = i;
            if(count[i] == 0)
                missing = i;
        }

        return new int[]{duplicate, missing};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna