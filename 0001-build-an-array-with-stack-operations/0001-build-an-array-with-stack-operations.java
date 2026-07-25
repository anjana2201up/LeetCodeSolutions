import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int current = 1;

        for(int num : target) {
            while(current < num) {
                ans.add("Push");
                ans.add("Pop");
                current++;
            }

            ans.add("Push");
            current++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna