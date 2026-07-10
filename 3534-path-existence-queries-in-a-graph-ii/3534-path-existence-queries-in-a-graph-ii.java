import java.util.*;

public class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Track which values exist in the array
        boolean[] exists = new boolean[maxVal + 1];
        for (int num : nums) {
            exists[num] = true;
        }
        
        // nextChoice[x] stores the largest existing value <= x
        int[] nextChoice = new int[maxVal + 1];
        int last = -1;
        for (int i = 0; i <= maxVal; i++) {
            if (exists[i]) {
                last = i;
            }
            nextChoice[i] = last;
        }
        
        // up[x][k] stores the value reached from 'x' after 2^k optimal rightward steps
        int LOG = 18; // 2^17 = 131072 > 100000
        int[][] up = new int[maxVal + 1][LOG];
        
        for (int i = 0; i <= maxVal; i++) {
            if (!exists[i]) continue;
            // The furthest we can jump from i is min(maxVal, i + maxDiff)
            int target = Math.min(maxVal, i + maxDiff);
            up[i][0] = nextChoice[target];
        }
        
        // Fill the binary lifting table
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i <= maxVal; i++) {
                if (!exists[i]) continue;
                up[i][k] = up[up[i][k - 1]][k - 1];
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == v) {
                answer[i] = 0;
                continue;
            }
            
            int A = nums[u];
            int B = nums[v];
            
            if (A == B) {
                answer[i] = 1; // Different node indices but same value -> distance is 1
                continue;
            }
            
            // Swap to ensure we are always jumping from smaller to larger value
            if (A > B) {
                int temp = A;
                A = B;
                B = temp;
            }
            
            // Check if B is completely unreachable from A even with max jumps
            if (up[A][LOG - 1] < B) {
                answer[i] = -1;
                continue;
            }
            
            // Use binary lifting to count the steps
            int steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (up[A][k] < B) {
                    A = up[A][k];
                    steps += (1 << k);
                }
            }
            
            // One final step to reach or overshoot B
            answer[i] = steps + 1;
        }
        
        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna