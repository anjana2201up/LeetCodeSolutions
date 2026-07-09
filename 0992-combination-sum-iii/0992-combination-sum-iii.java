class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int start,
                           int k,
                           int remaining,
                           List<Integer> path,
                           List<List<Integer>> ans) {

        if (remaining == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (remaining < 0 || path.size() == k)
            return;

        for (int i = start; i <= 9; i++) {

            path.add(i);

            backtrack(i + 1,
                      k,
                      remaining - i,
                      path,
                      ans);

            path.remove(path.size() - 1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna