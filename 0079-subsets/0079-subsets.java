class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        buildSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void buildSubsets(int index, int[] nums,
                              List<Integer> current,
                              List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);

            buildSubsets(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna